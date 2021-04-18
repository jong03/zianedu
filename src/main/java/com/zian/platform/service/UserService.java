package com.zian.platform.service;


import com.zian.platform.model.dto.RoleDto;
import com.zian.platform.model.dto.UserDto;
import com.zian.platform.model.entity.RoleEntity;
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
        var role = roleRepository.findById(1l);
        var roleEntity = role.get();
        List<RoleDto.Request> roles = new ArrayList<>();
        RoleDto.
        roles.add(roleEntity);

        userRequestDto.setRoles(roles);
        return userMapper.toDto(userRepository.save(
                userMapper.toEntity(userRequestDto)
        ));
    }

}
