package de.htw.berlin.jwt;

import de.htw.berlin.jwt.db.UserRepository;
import de.htw.berlin.jwt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
