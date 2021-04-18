package com.zian.platform.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zian.platform.model.entity.RoleEntity;
import lombok.*;

import java.util.List;

public class UserDto {

    @Setter
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    @ToString
    public static class Request{

        private String username;
        private String password;
        private List<RoleDto.Request> roles;
    }

    @Setter
    @Getter
    @Builder
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    @ToString
    public static class Response{

        private Long id;
        private String username;
        private String password;
        private Boolean enabled;

        private List<RoleDto.Response> roles;
    }

}
