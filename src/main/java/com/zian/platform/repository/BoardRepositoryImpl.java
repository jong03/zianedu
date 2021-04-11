package com.zian.platform.repository;

import com.querydsl.jpa.JPQLQuery;
import com.zian.platform.model.entity.BoardEntity;
import com.zian.platform.model.entity.QBoardEntity;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class BoardRepositoryImpl extends QuerydslRepositorySupport implements BoardRepositoryCustom {

  public BoardRepositoryImpl(EntityManager em) {
    super(BoardEntity.class);
  }

  @Override
  public Page<BoardEntity> findAllWithPaging(String title, Pageable pageable) {

//    JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());
    final QBoardEntity qBoardEntity = QBoardEntity.boardEntity;
    final JPQLQuery<BoardEntity> query;

    query = from(qBoardEntity);

    if (!StringUtils.isEmpty(title)) {
      query.where(qBoardEntity.title.contains(title));
    }

    final List<BoardEntity> list = getQuerydsl().applyPagination(pageable, query).fetch();

    return new PageImpl<>(
        list, pageable, query.fetchCount()
    );
  }
}
