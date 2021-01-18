package springboard.demo.repository;

import springboard.demo.domain.Board;

public interface BoardRepository {

    // 게시글 작성
    public void write(Board board);
}
