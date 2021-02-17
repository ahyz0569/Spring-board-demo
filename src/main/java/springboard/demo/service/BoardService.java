package springboard.demo.service;

import springboard.demo.dto.BoardDTO;
import springboard.demo.dto.BoardForm;

import java.util.List;

public interface BoardService {

    // 게시글 작성
    Long uploadPost(BoardForm boardForm);
    
    // 게시글 목록
    List<BoardDTO> list(Integer pageNum);

    // 게시글 조회
    BoardDTO read(Long id);

    // 게시글 수정
    void updatePost(BoardDTO boardDTO);

    // 게시글 삭제
    void deletePost(Long id);
    
    // 총 게시물 갯수
    Long getBoardCount();

    Integer[] getPageList(Integer pageNum);
}
