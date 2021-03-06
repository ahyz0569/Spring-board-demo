package springboard.demo.repository;

import springboard.demo.domain.Board;

import java.util.List;

public interface BoardRepository {

    // 게시글 작성
    void write(Board board);

    // 게시글 목록
    List<Board> findAll();

    // 게시글 목록(해당 페이지 별)
    List<Board> findPerPage(int startPosition, int maxResult);

    // 게시글 조회
    Board findOne(Long id);

    // 게시글 삭제
    void delete(Long id);

    // 총 게시물 갯수
    Long count();
}
