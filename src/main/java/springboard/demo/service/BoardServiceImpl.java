package springboard.demo.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboard.demo.domain.Board;
import springboard.demo.dto.BoardDTO;
import springboard.demo.repository.BoardRepository;
import springboard.demo.dto.BoardForm;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public Long uploadPost(BoardForm boardForm) {
        Board board = Board.createBoard(boardForm.getTitle(), boardForm.getWriter(), boardForm.getContent());
        boardRepository.write(board);
        return board.getId();
    }

    @Override
    public List<BoardDTO> list() {
        List<Board> boardList = boardRepository.findAll();
        return boardList.stream()
                .map(board -> modelMapper.map(board, BoardDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BoardDTO read(Long id) {
        Board board = boardRepository.findOne(id);
        return modelMapper.map(board, BoardDTO.class);
    }
}
