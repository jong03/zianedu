package com.zian.platform.service;

import com.zian.platform.common.mapper.BaseGenericMapper;
import com.zian.platform.model.dto.BoardDto;
import com.zian.platform.model.entity.BoardEntity;
//import com.zian.platform.model.mapper.BoardMapper;
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
  private final BoardMapper boardMapper;

  /** 게시글 - 등록 */
  @Transactional
  public BoardDto.Response save(BoardDto.Request boardRequestDto) {
    return boardMapper.toDto(boardRepository.save(
        boardMapper.toEntity(boardRequestDto)
    ));
  }

  /** 게시글 - 수정 */
  @Transactional
  public BoardDto.Response update(Long boardId, BoardDto.Request boardRequestDto) {

    var boardEntityOptional = boardRepository.findById(boardId);
    if (!boardEntityOptional.isPresent()) {
      // exception 발생
    }
    var boardEntity = boardEntityOptional.get();
    boardEntity.setWriter(boardRequestDto.getWriter());
    boardEntity.setTitle(boardRequestDto.getWriter());
    boardEntity.setContent(boardRequestDto.getWriter());

    return boardMapper.toDto(boardRepository.save(boardEntity));
  }

  /** 게시글 - 삭제 */
  @Transactional
  public Long delete(Long boardId) {

    var boardEntityOptional = boardRepository.findById(boardId);
    if (!boardEntityOptional.isPresent()) {
      // exception 발생
    }
    boardRepository.delete(boardEntityOptional.get());

    return boardId;
  }

}
