package springboard.demo.service;

import springboard.demo.domain.Board;
import springboard.demo.vo.BoardForm;

public interface BoardService {

    // 게시글 작성
    public Long uploadPost(BoardForm boardForm);
}
