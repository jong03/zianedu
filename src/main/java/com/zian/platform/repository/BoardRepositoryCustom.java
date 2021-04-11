package com.zian.platform.repository;

import com.zian.platform.model.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardRepositoryCustom {
  public Page<BoardEntity> findAllWithPaging(String title, Pageable pageable);
}
