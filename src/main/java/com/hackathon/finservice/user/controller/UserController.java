package com.hackathon.finservice.user.controller;

import com.hackathon.finservice.user.dto.UserRegisterDtoIn;
import com.hackathon.finservice.user.dto.UserRegisterDtoOut;
import com.hackathon.finservice.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserServiceImpl userService;

  @PostMapping("/register")
  public ResponseEntity<UserRegisterDtoOut> registerUser(@RequestBody UserRegisterDtoIn userRegisterDtoIn) {
    UserRegisterDtoOut userRegisterDtoOut = userService.registerUser(userRegisterDtoIn);
    return ResponseEntity.ok(userRegisterDtoOut);

  }

}
