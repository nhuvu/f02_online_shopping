package com.example.f02_online_shopping.exception;

public class UserException extends ApiException {

  //UserException này là con của ApiException -> cũng sẽ dc xử lý với định nghĩa của ApiException
  public UserException(int httpCode, String message) {
    super(httpCode, message);
  }
}
