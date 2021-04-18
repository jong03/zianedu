package com.zian.platform.model.mapper;

import com.zian.platform.config.MapStructConfig;
import com.zian.platform.model.dto.UserDto;
import com.zian.platform.model.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface UserMapper {

    UserEntity toEntity(UserDto.Request source);

    UserDto.Response toDto(UserEntity source);

}
