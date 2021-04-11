package com.zian.platform.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ErrorResponse {

  private final Integer statusCode;
  private final ErrorMessage error;

  public ErrorResponse(ErrorCode errorCode) {
    this.statusCode = errorCode.getStatusCode();
    this.error = new ErrorMessage(errorCode.getCategory(), errorCode.name(), errorCode.getMessage());
  }

  public ErrorResponse(ErrorCode errorCode, String message) {
    this.statusCode = errorCode.getStatusCode();
    this.error = new ErrorMessage(errorCode.getCategory(), errorCode.name(), message);
  }

  @Getter
  @RequiredArgsConstructor
  private static class ErrorMessage {
    private final String category;
    private final String errorCode;
    private final String message;
  }
}
