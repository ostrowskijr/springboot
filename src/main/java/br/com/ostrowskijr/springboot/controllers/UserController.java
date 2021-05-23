package br.com.ostrowskijr.springboot.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ostrowskijr.springboot.models.User;

@RestController
@RequestMapping("/user")
public class UserController {

    List<User> users = new ArrayList<>();

    @GetMapping("/user/{id}")
    public User getUser() {
        Optional<User> userFilter = users.stream().filter(user -> user.getId() == id).findFirst();
        if (userFilter.isPresent()) {
            return userFilter.get();
        }
        return null;
    }

    @PostMapping("/add")
    public User add(@RequestBody User user) {
        users.add(user);
        return user;
    }

    @GetMapping("/list")
    public List<User> listUsers() {
        return users;
    }
}
