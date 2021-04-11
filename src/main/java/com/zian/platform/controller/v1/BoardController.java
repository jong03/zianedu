package com.zian.platform.controller.v1;

import com.zian.platform.model.dto.BoardDto;
import com.zian.platform.model.dto.BoardDto.Response;
import com.zian.platform.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = {"/api/v1/board"})
public class BoardController {

  private final BoardService boardService;

  /** 게시글 - 등록 */
  @PostMapping(value = "")
  public ResponseEntity<Response> save(@RequestBody BoardDto.Request boardRequestDto) {

    return new ResponseEntity<BoardDto.Response>(boardService.save(boardRequestDto), HttpStatus.CREATED);
  }

  /** 게시글 - 수정 */
  @PutMapping(value = "/{boardId}")
  public ResponseEntity<Response> update(@PathVariable("boardId") Long boardId, @RequestBody BoardDto.Request boardRequestDto) {
    return new ResponseEntity<BoardDto.Response>(boardService.update(boardId, boardRequestDto), HttpStatus.CREATED);
  }

  /** 게시글 - 삭제 */
  @DeleteMapping(value = "/{boardId}")
  public ResponseEntity<Long> delete(@PathVariable("boardId") Long boardId) {

    boardService.delete(boardId);
    return new ResponseEntity<Long>(boardId, HttpStatus.NO_CONTENT);
  }

  /** 게시글 - 목록 조회 - 페이징 */
  @GetMapping(value = "")
  public ResponseEntity<Page<Response>> list(
      @RequestParam(name = "title", required = false) String title,
      @RequestParam(name = "page") int page,
      @RequestParam(name = "size") int size
  ) {

    PageRequest pageRequest = PageRequest.of(page, size);

    return new ResponseEntity<Page<Response>>(boardService.list(title, pageRequest), HttpStatus.OK);
  }

}
