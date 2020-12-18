package de.htw.berlin.MensaTalk.MensaTalkBackend.jwt.controller;

import de.htw.berlin.MensaTalk.MensaTalkBackend.User.model.User;
import de.htw.berlin.MensaTalk.MensaTalkBackend.User.model.UserDTO;
import de.htw.berlin.MensaTalk.MensaTalkBackend.jwt.config.JwtTokenUtil;
import de.htw.berlin.MensaTalk.MensaTalkBackend.User.dao.UserRepository;
import de.htw.berlin.MensaTalk.MensaTalkBackend.jwt.request.*;
import de.htw.berlin.MensaTalk.MensaTalkBackend.jwt.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        User tempUser = userDetailsService.save(user);
        if (tempUser == null) {
            return ResponseEntity.badRequest().body("Username taken!");
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(tempUser.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/verifyUserNameWithToken", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody VerifyRequest VerifyRequest) throws Exception {

        if (jwtTokenUtil.getUsernameFromToken(VerifyRequest.getJwtToken()).equals(VerifyRequest.getUserName())) {
            return ResponseEntity.ok(userRepository.findByUsername(VerifyRequest.getUserName()).getId());
        } else {
            return ResponseEntity.badRequest().body("UserName does not match Token!");
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}