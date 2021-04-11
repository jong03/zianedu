package com.zian.platform.repository;

import com.zian.platform.model.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>, BoardRepositoryCustom {
}
