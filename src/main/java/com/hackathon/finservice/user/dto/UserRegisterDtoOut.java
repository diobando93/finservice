package com.hackathon.finservice.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDtoOut {

  private String name;
  private String email;
  private String accountNumber;
  private String accountType;
  private String hashedPassword;

}
