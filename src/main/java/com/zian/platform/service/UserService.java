package com.zian.platform.service;


import com.zian.platform.exception.ApiErrorException;
import com.zian.platform.exception.ErrorCode;
import com.zian.platform.model.dto.RoleDto;
import com.zian.platform.model.dto.UserDto;
import com.zian.platform.model.entity.RoleEntity;
import com.zian.platform.model.entity.UserEntity;
import com.zian.platform.model.mapper.UserMapper;
import com.zian.platform.repository.RoleRepository;
import com.zian.platform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    /** 게시글 - 등록 */
    @Transactional
    public UserDto.Response save(UserDto.Request userRequestDto) {

        /*권한저장이 필요함*/
        var roleEntity = roleRepository.findById(1l).orElseThrow(
            () -> new ApiErrorException(ErrorCode.ROLE_NOTFOUND)
        );

        UserEntity userEntity = userMapper.toEntity(userRequestDto);
        userEntity.setRoles(List.of(roleEntity));

        // 사용자에게 Role을 매핑해서 사용자 저장하면 된다.
        // 저장
//        UserEntity userEntity = userRepository.save(
//            UserEntity.builder()
//                .username(userRequestDto.getUsername())
//                .password(userRequestDto.getPassword())
//                .roles(List.of(roleEntity)).build()
//        );

        return userMapper.toDto(userRepository.save(
                userEntity
        ));
    }

}
