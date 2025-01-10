package com.hackathon.finservice.exception;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiErrorCode {

//@formatter:off
  EMAIL_NOT_NULL("USER001", "Email must not be null", HttpStatus.CONFLICT), 
  NAME_NOT_NULL("USER002", "Name must not be null", HttpStatus.CONFLICT),
  PASSWORD_NOT_NULL("USER003", "Password must not be null", HttpStatus.CONFLICT),
  USER_EXITS("USER004", "This user '%s' exits", HttpStatus.CONFLICT),
  ORDER_NOT_EXISTS("ORD001", "Order for idCart/idProduct: '%s/%s' not exists", HttpStatus.CONFLICT);
//@formatter:on

  private final String     code;
  private final String     message;
  private final HttpStatus status;

  public String getMessage(Object... args) {
    return String.format(message, args);
  }
}
