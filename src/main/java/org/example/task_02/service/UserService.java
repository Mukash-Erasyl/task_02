package org.example.task_02.service;

import org.example.task_02.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<User> getAll();
    Mono<User> getById(Long id);
    Mono<User> create(User user);
    Mono<User> update(Long id, User user);
    Mono<User> delete(Long id);
}
