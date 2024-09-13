package org.example.task_02.handler;

import org.example.task_02.domain.User;
import org.example.task_02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class UserHandler {
    private final UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public Mono<ServerResponse> update(ServerRequest request){
        var id = Long.valueOf(request.pathVariable("id"));
        return request.bodyToMono(User.class)
                .flatMap(user -> userService.update(id, user))
                .flatMap(user -> ServerResponse.ok().bodyValue(user))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        var id = Long.valueOf(request.pathVariable("id"));
        return userService.delete(id)
                .flatMap(user -> ServerResponse.noContent().build())
                .switchIfEmpty(ServerResponse.notFound().build());
    }

}
