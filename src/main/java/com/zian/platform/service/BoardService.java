package com.zian.platform.service;

import com.zian.platform.common.mapper.BaseGenericMapper;
import com.zian.platform.model.dto.BoardDto;
import com.zian.platform.model.entity.BoardEntity;
import com.zian.platform.model.mapper.BoardMapper;
import com.zian.platform.repository.BoardRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;
  private final BaseGenericMapper<BoardDto.Request, BoardEntity> boardRequestMapper;

  /** 게시글 - 등록 */
  @Transactional
  public BoardDto.Response save(BoardDto.Request boardRequestDto) {

    log.info(boardRequestDto.toString());

    log.info(boardRequestMapper.toEntity(boardRequestDto).toString());

    return null;

//    return boardRepository.save(boardSaveRequestDto.toEntity())
//        .getBoardSeq();
  }

}
