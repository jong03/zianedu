package com.zian.platform.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

  BOARD_NOTFOUND(400, "BAD_REQUEST", "zian.error.board_notfound");

  private final Integer statusCode;
  private final String category;
  private final String message;
}

