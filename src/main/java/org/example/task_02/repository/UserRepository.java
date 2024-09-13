package org.example.task_02.repository;

import org.example.task_02.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {
    Mono<User> findById(Long id);
    Flux<User> findAll();
    Mono<User> save(User user);
    Mono<User> update(Long id, User user);
    Mono<User> delete(Long id);
}