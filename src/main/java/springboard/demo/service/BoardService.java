package springboard.demo.service;

import springboard.demo.domain.Board;
import springboard.demo.vo.BoardForm;

import java.util.List;

public interface BoardService {

    // 게시글 작성
    Long uploadPost(BoardForm boardForm);
    
    // 게시글 목록
    List<Board> list();
}
