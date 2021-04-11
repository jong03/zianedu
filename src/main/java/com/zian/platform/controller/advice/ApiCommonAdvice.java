package com.zian.platform.controller.advice;

import com.zian.platform.exception.ApiErrorException;
import com.zian.platform.exception.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Order(value = 1)
@RestControllerAdvice(basePackages = "com.zian.platform.controller")
@RequiredArgsConstructor
public class ApiCommonAdvice {

  private final MessageSource messageSource;

  @ExceptionHandler(ApiErrorException.class)
  public ResponseEntity<ErrorResponse> handleBusinessException(ApiErrorException e) {
    log.error("error code : {}, error message : {}, error args {}", e.getErrorCode(), getMessage(e.getMessage(), e.getArgs()));

    ErrorResponse response = new ErrorResponse(e.getErrorCode(), getMessage(e.getMessage(), e.getArgs()));
    return new ResponseEntity<>(response, HttpStatus.valueOf(e.getErrorCode().getStatusCode()));
  }

  private String getMessage(String code, Object[] args) {
    return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
  }
}
