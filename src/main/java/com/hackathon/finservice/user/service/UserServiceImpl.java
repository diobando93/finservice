package com.hackathon.finservice.user.service;

import com.hackathon.finservice.Entities.User;
import com.hackathon.finservice.user.dto.UserRegisterDtoIn;
import com.hackathon.finservice.user.dto.UserRegisterDtoOut;
import com.hackathon.finservice.user.mapper.UserMapper;
import com.hackathon.finservice.user.repository.UserRepository;
import com.hackathon.finservice.user.service.helper.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository              userRepository;

  @Autowired
  private UserMapper                  userMapper;

  @Autowired
  private UserValidator               userValidator;

  private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  @Override
  public UserRegisterDtoOut registerUser(UserRegisterDtoIn userRegisterDtoIn) {

    userValidator.registerData(userRegisterDtoIn);

    userValidator.emailExits(userRegisterDtoIn.getEmail());

    User newUser = createUser(userRegisterDtoIn);

    return userMapper.registerDtoOut(newUser);
  }

  protected User createUser(UserRegisterDtoIn userRegisterDtoIn) {

    User user = new User();
    user.setName(userRegisterDtoIn.getName());
    user.setEmail(userRegisterDtoIn.getEmail());
    user.setPassword(passwordEncoder.encode(userRegisterDtoIn.getPassword()));
    userRepository.save(user);

    return user;

  }

}
