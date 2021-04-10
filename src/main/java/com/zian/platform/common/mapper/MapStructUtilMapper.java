package com.zian.platform.common.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
public class MapStructUtilMapper {

  @Named("DtoToMapStringValue")
  public Map<String,String> dtoToMapStringValue(Object source) {
    Map<String, String> map = null;
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      map = objectMapper.convertValue(source, Map.class);
    }
    catch (Exception e) {}
    return map;
  }

  @Named("DtoToMapDoubleValue")
  public Map<String,Double> dtoToMapDoubleValue(Object source) {
    Map<String, Double> map = null;
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      map = objectMapper.convertValue(source, Map.class);
    }
    catch (Exception e) {}
    return map;
  }
}
