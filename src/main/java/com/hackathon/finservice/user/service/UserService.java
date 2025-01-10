package com.hackathon.finservice.user.service;

import com.hackathon.finservice.user.dto.UserRegisterDtoIn;
import com.hackathon.finservice.user.dto.UserRegisterDtoOut;

public interface UserService {

  public UserRegisterDtoOut registerUser(UserRegisterDtoIn userRegisterDtoIn);

}
