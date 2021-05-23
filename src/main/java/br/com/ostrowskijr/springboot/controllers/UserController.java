package br.com.ostrowskijr.springboot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ostrowskijr.springboot.models.User;
import br.com.ostrowskijr.springboot.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    List<User> users = new ArrayList<>();
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return this.userRepository.findById(id).get();
    }

    @GetMapping("/morethan/{id}")
    public List<User> getUserMoreThen(@PathVariable("id") Long id) {
        return this.userRepository.findAllMoreThan(id);
    }

    @GetMapping("/fidByName/{name}")
    public List<User> getByName(@PathVariable("name") String name) {
        return this.userRepository.findByName(name);
    }

    @PostMapping("/add")
    public User add(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void remove(@PathVariable("id") Long id) {
        this.userRepository.delete(this.userRepository.findById(id).get());
    }

    @GetMapping("/list")
    public List<User> listUsers() {
        return this.userRepository.findAll();
    }
}
