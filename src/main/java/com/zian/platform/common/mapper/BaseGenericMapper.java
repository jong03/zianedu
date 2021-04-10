package com.zian.platform.common.mapper;

public interface BaseGenericMapper<D, E> {
  D toDto(E source);
  E toEntity(D source);
}
