package org.example.task_02.service;

import org.example.task_02.domain.User;
import org.example.task_02.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DefaultUserService implements UserService {
    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Flux<User> getAll(){
        return this.userRepository.findAll();
    }
    public Mono<User> getById(Long id){
        return this.userRepository.findById(id);
    }

    public Mono<User> create(User user){
        return this.userRepository.save(user);
    }

    public Mono<User> update(Long id, User user){
        return this.userRepository.update(id, user);
    }

    public Mono<User> delete(Long id){
        return userRepository.delete(id);
    }

}
