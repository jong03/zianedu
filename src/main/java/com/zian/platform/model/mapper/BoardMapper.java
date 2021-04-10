package com.zian.platform.model.mapper;

import com.zian.platform.common.mapper.BaseGenericMapper;
import com.zian.platform.config.MapStructConfig;
import com.zian.platform.model.dto.BoardDto;
import com.zian.platform.model.entity.BoardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface BoardMapper extends BaseGenericMapper<BoardDto, BoardEntity> {

  @Override
  @Mapping(source = "Request.writer",           target = "writer")
  @Mapping(source = "Request.title",           target = "title")
  @Mapping(source = "Request.content",           target = "content")
  BoardEntity toEntity(BoardDto source);

//  @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now().toInstant(java.time.ZoneOffset.UTC).toEpochMilli())")
//  @Mapping(target = "origin", constant = "zoo-push")
//  @Mapping(source = ".", target = "payload")
//  KafkaPayloadDto<FulfillmentDto> toKafkaPayload(FulfillmentDto source);
}