package com.zian.platform.repository;

import com.zian.platform.model.entity.BoardEntity;
import com.zian.platform.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>  {
}
