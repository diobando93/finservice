package com.hackathon.finservice.user.service.helper;

import java.util.Optional;
import com.hackathon.finservice.Entities.User;
import com.hackathon.finservice.exception.ApiErrorCode;
import com.hackathon.finservice.exception.ApiException;
import com.hackathon.finservice.user.dto.UserRegisterDtoIn;
import com.hackathon.finservice.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

  @Autowired
  private UserRepository userRepository;

  public void registerData(UserRegisterDtoIn userRegisterDtoIn) {

    if (userRegisterDtoIn.getEmail() == null) {
      throw new ApiException(ApiErrorCode.EMAIL_NOT_NULL.getMessage(), ApiErrorCode.EMAIL_NOT_NULL.getStatus());
    }
    if (userRegisterDtoIn.getName() == null) {
      throw new ApiException(ApiErrorCode.NAME_NOT_NULL.getMessage(), ApiErrorCode.NAME_NOT_NULL.getStatus());
    }
    if (userRegisterDtoIn.getPassword() == null) {
      throw new ApiException(ApiErrorCode.PASSWORD_NOT_NULL.getMessage(), ApiErrorCode.EMAIL_NOT_NULL.getStatus());
    }

  }

  public void emailExits(String email) {

    Optional<User> existingUser = userRepository.findByEmail(email);

    if (existingUser.isPresent()) {
      throw new ApiException(ApiErrorCode.USER_EXITS.getMessage(), ApiErrorCode.USER_EXITS.getStatus());
    }
  }

}
