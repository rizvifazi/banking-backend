package com.banking.netportal.controller;

import com.banking.netportal.entity.User;
import com.banking.netportal.service.AuthService;
import com.banking.netportal.dto.LoginRequest;
import com.banking.netportal.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  private AuthService authService;

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
    authService.register(registerRequest);
    return ResponseEntity.ok("User registered successfully");
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
    String token = authService.login(loginRequest);
    return ResponseEntity.ok(token);
  }

  @GetMapping("/user")
  public ResponseEntity<User> getUser(@RequestParam String username) {
    User user = authService.getUserByUsername(username);
    return ResponseEntity.ok(user);
  }
}