package com.zian.platform.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

public class BoardDto {


  @Setter
  @Getter
  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  @ToString
  public static class Request {
    private String writer;
    private String title;
    private String content;
  }

  @Setter
  @Getter
  @Builder
//  @NoArgsConstructor
  @AllArgsConstructor
  @JsonIgnoreProperties(ignoreUnknown = true)
  @ToString
  public static class Response {

    private Long id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

  }


}
