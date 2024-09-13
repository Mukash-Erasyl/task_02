package org.example.task_02.controller;

import org.example.task_02.domain.User;
import org.example.task_02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Flux<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<User>> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Mono<User>> create(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(user));
    }
}
