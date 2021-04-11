package com.zian.platform.service;

import com.zian.platform.common.mapper.BaseGenericMapper;
import com.zian.platform.exception.ApiErrorException;
import com.zian.platform.exception.ErrorCode;
import com.zian.platform.model.dto.BoardDto;
import com.zian.platform.model.entity.BoardEntity;
//import com.zian.platform.model.mapper.BoardMapper;
import com.zian.platform.model.mapper.BoardMapper;
import com.zian.platform.repository.BoardRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
      throw new ApiErrorException(ErrorCode.BOARD_NOTFOUND);
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
      throw new ApiErrorException(ErrorCode.BOARD_NOTFOUND);
    }
    boardRepository.delete(boardEntityOptional.get());

    return boardId;
  }

  /** 게시글 - 목록 조회 - 페이징 */
  public Page<BoardDto.Response> list(String title, Pageable pageable) {
    return boardRepository.findAllWithPaging(title, pageable)
        .map(boardMapper::toDto);
  }

}
