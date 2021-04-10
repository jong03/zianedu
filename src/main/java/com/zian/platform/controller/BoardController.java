package com.zian.platform.controller;

import com.zian.platform.model.dto.BoardDto;
import com.zian.platform.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = {"/api/v1/board"})
public class BoardController {

  private final BoardService boardService;

//  /** 게시글 - 목록 조회  */
//  @GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
//  public ResponseEntity<List<BoardResponseDto>> findAll() {
//
//    List<BoardResponseDto> boardResponseDtoList = boardService.findAll();
//
//    return new ResponseEntity<List<BoardResponseDto>>(boardResponseDtoList, HttpStatus.OK);
//  }
//
//  /** 게시글 - 상세 조회 */
//  @GetMapping(value = "/{boardSeq}", produces = { MediaType.APPLICATION_JSON_VALUE })
//  public ResponseEntity<BoardResponseDto> findById(@PathVariable("boardSeq") Long boardSeq) {
//
//    BoardResponseDto boardResponseDto = boardService.findById(boardSeq);
//
//    return new ResponseEntity<BoardResponseDto>(boardResponseDto, HttpStatus.OK);
//  }
//
  /** 게시글 - 등록 */
  @PostMapping(value = "")
  public ResponseEntity<BoardDto.Response> save(@RequestBody BoardDto.Request boardRequestDto) {

    return new ResponseEntity<BoardDto.Response>(boardService.save(boardRequestDto), HttpStatus.CREATED);
  }

  /** 게시글 - 수정 */
  @PutMapping(value = "/{boardId}")
  public ResponseEntity<BoardDto.Response> update(@PathVariable("boardId") Long boardId, @RequestBody BoardDto.Request boardRequestDto) {
    return new ResponseEntity<BoardDto.Response>(boardService.update(boardId, boardRequestDto), HttpStatus.CREATED);
  }

  /** 게시글 - 삭제 */
  @DeleteMapping(value = "/{boardId}")
  public ResponseEntity<Long> delete(@PathVariable("boardId") Long boardId) {

    boardService.delete(boardId);
    return new ResponseEntity<Long>(boardId, HttpStatus.NO_CONTENT);
  }

}
