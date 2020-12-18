package de.htw.berlin.MensaTalk.MensaTalkBackend.User.controller;

import de.htw.berlin.MensaTalk.MensaTalkBackend.User.dao.UserRepository;
import de.htw.berlin.MensaTalk.MensaTalkBackend.User.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // Direkter Zugriff
    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getOneUser(@PathVariable(value = "id") long id) {
        return userRepository.findById(id).get();
    }
}
