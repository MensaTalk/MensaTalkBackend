package de.htw.berlin.MensaTalk.MensaTalkBackend.User.controller;

import de.htw.berlin.MensaTalk.MensaTalkBackend.User.dao.UserRepository;
import de.htw.berlin.MensaTalk.MensaTalkBackend.User.model.ProfileUserDTO;
import de.htw.berlin.MensaTalk.MensaTalkBackend.User.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "/users", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public User updateUser( @RequestBody ProfileUserDTO profileUserDTO) {
        Optional<User> userOptional = userRepository.findById(profileUserDTO.getId());
        User toUpdate;
        if (userOptional.isPresent()) {
            toUpdate = userOptional.get();
        } else {
            return null;
        }

        toUpdate.setAge(profileUserDTO.getAge());
        toUpdate.setInterests(profileUserDTO.getInterests());
        toUpdate.setStatus(profileUserDTO.getStatus());


        return userRepository.save(toUpdate);
    }
}
