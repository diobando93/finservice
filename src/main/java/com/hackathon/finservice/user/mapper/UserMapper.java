package com.hackathon.finservice.user.mapper;

import com.hackathon.finservice.Entities.User;
import com.hackathon.finservice.user.dto.UserRegisterDtoOut;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public UserRegisterDtoOut registerDtoOut(User user) {

    UserRegisterDtoOut userRegisterDtoOut = new UserRegisterDtoOut();
    userRegisterDtoOut.setName(user.getName());
    userRegisterDtoOut.setEmail(user.getEmail());
    userRegisterDtoOut.setAccountNumber(user.getAccountNumber());
    userRegisterDtoOut.setAccountType(user.getAccountType());
    userRegisterDtoOut.setHashedPassword(user.getPassword());

    return userRegisterDtoOut;
  }

}
