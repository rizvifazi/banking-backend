package com.banking.netportal.service.impl;

import com.banking.netportal.service.AuthService;
import com.banking.netportal.entity.User;
import com.banking.netportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class AuthServiceImpl implements AuthService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public User registerUser(String email, String password, String firstName, String lastName) {
    if (userRepository.existsByEmail(email)) {
      throw new RuntimeException("User already exists");
    }
    User user = new User();
    user.setEmail(email);
    user.setPassword(passwordEncoder.encode(password));
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setCreatedAt(LocalDateTime.now());
    return userRepository.save(user);
  }

  public User loginUser(String email, String password) {
    User user = userRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("User not found"));
    if (!passwordEncoder.matches(password, user.getPassword())) {
      throw new RuntimeException("Invalid password");
    }
    return user;
  }

  public User getUserByEmail(String email) {
    return userRepository.findByEmail(email).orElse(null);
  }

}