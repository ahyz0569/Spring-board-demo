package springboard.demo.service;

import springboard.demo.domain.Board;
import springboard.demo.dto.BoardDTO;
import springboard.demo.dto.BoardForm;

import java.util.List;

public interface BoardService {

    // 게시글 작성
    Long uploadPost(BoardForm boardForm);
    
    // 게시글 목록
    List<BoardDTO> list();

    // 게시글 조회
    BoardDTO read(Long id);
}
