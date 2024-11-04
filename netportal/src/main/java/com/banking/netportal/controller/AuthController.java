package com.banking.netportal.controller;

import com.banking.netportal.entity.User;
import com.banking.netportal.service.impl.AuthServiceImpl;
import com.banking.netportal.dto.request.LoginRequest;
import com.banking.netportal.dto.request.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  private AuthServiceImpl authServiceImpl;

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody RegistrationRequest registrationRequest) {
    try {
      if (authServiceImpl.getUserByEmail(registrationRequest.getEmail()) != null) {
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body("Email already registered");
    }
    
    User user = authServiceImpl.registerUser(
      registrationRequest.getEmail(), 
      registrationRequest.getPassword(),
      registrationRequest.getFirstName(),
      registrationRequest.getLastName()
    );
      return ResponseEntity.ok("User registered successfully" + user.getEmail());

    } catch (Exception e) {
      return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Registration failed :" + e.getMessage());
    }
  }

  @PostMapping("/login")
  public ResponseEntity<User> login(@RequestBody LoginRequest loginRequest) {
    User user = authServiceImpl.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
    return ResponseEntity.ok(user);
  }

  @GetMapping("/user")
  public ResponseEntity<User> getUser(@RequestParam String email) {
    User user = authServiceImpl.getUserByEmail(email);
    return ResponseEntity.ok(user);
  }
}