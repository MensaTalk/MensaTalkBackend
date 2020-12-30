package de.htw.berlin.MensaTalk.MensaTalkBackend.User.controller;

import de.htw.berlin.MensaTalk.MensaTalkBackend.User.dao.UserRepository;
import de.htw.berlin.MensaTalk.MensaTalkBackend.User.model.ProfileUserDTO;
import de.htw.berlin.MensaTalk.MensaTalkBackend.User.model.User;
import de.htw.berlin.MensaTalk.MensaTalkBackend.awsBucket.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ImageService imageService;

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
    public User updateUser(@RequestBody ProfileUserDTO profileUserDTO) {
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

    @RequestMapping(path = "/users/{id}/imageupload", method = RequestMethod.POST, consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void imageupload(@PathVariable(value = "id") long id, HttpServletRequest request) throws IOException {
        User user = userRepository.findById(id).get();

        int salt = (int) (Math.random() * 100);
        StringBuilder sb = new StringBuilder();
        sb.append("profileImage_");
        sb.append(user.getId());
        sb.append(salt);

        String fileName = sb.toString();
        user.setAmazonUrl(fileName);

        userRepository.save(user);
        imageService.uploadTos3bucket(fileName, request.getInputStream());
        
    }
}
