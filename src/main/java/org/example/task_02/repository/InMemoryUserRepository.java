package org.example.task_02.repository;

import org.example.task_02.domain.User;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final Map<Long, User> users = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public Mono<User> findById(Long id) {
        return Mono.justOrEmpty(users.get(id));
    }

    public Flux<User> findAll() {
        return Flux.fromIterable(users.values());
    }

    public Mono<User> save(User user) {
        var id = nextId.getAndIncrement();
        user.setId(id);
        users.put(user.getId(), user);
        return Mono.just(user);
    }

    public Mono<User> update(Long id, User user) {
            users.put(user.getId(), user);
            return Mono.justOrEmpty(user);
    }

    public Mono<User> delete(Long id) {
        return Mono.justOrEmpty(users.remove(id));
    }
}
