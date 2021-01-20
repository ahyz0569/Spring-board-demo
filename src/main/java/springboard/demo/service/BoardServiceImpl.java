package springboard.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboard.demo.domain.Board;
import springboard.demo.repository.BoardRepository;
import springboard.demo.vo.BoardForm;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public Long uploadPost(BoardForm boardForm) {
        Board board = Board.createBoard(boardForm.getTitle(), boardForm.getWriter(), boardForm.getContent());
        boardRepository.write(board);
        return board.getId();
    }

    @Override
    public List<Board> list() {
        return boardRepository.findAll();
    }

    @Override
    public Board read(Long id) {
        return boardRepository.findOne(id);
    }
}
