package com.zian.platform.model.mapper;

import com.zian.platform.common.mapper.BaseGenericMapper;
import com.zian.platform.config.MapStructConfig;
import com.zian.platform.model.dto.BoardDto;
import com.zian.platform.model.entity.BoardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface BoardMapper  {

  BoardEntity toEntity(BoardDto.Request source);

  BoardDto.Response toDto(BoardEntity source);

}