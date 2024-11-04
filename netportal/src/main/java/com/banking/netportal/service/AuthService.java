package com.banking.netportal.service;

import com.banking.netportal.entity.User;

public interface AuthService {
  User registerUser(String email, String password, String firstName, String lastName);
  User loginUser(String email, String password);
  User getUserByEmail(String email);
}
