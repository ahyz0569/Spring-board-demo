package springboard.demo.repository;

import springboard.demo.domain.Board;

import java.util.List;

public interface BoardRepository {

    // 게시글 작성
    void write(Board board);

    // 게시글 목록
    List<Board> findAll();
}
