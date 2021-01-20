package springboard.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import springboard.demo.domain.Board;
import springboard.demo.dto.BoardDTO;
import springboard.demo.dto.BoardForm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

@Transactional
public class ModelMapperTest {

    @Test
    public void ModelMapperSingleTest() throws Exception {
        // given
        Board board = Board.createBoard("안녕", "ㅇㅇ", "반가워용");

        // when
        ModelMapper modelMapper = new ModelMapper();
        BoardForm transBoard = modelMapper.map(board, BoardForm.class);

        // then
        assertThat(transBoard.getTitle()).isEqualTo(board.getTitle());
        assertThat(transBoard.getWriter()).isEqualTo(board.getWriter());
        assertThat(transBoard.getContent()).isEqualTo(board.getContent());
        assertThat(transBoard.getRegDate()).isEqualTo(board.getRegDate());
    }

    @Test
    public void ModelMapperListTest() throws Exception {

        // given
        Board board1 = Board.createBoard("안녕", "ㅇㅇ", "반가워용");
        Board board2 = Board.createBoard("hi", "dd", "안녕안녕");
        Board board3 = Board.createBoard("test", "gg", "hello");

        List<Board> boardList = new ArrayList<>();
        boardList.add(board1);
        boardList.add(board2);
        boardList.add(board3);

        // when
        ModelMapper modelMapper = new ModelMapper();
        List<BoardDTO> boardDTOList = boardList.stream()
                .map(board -> modelMapper.map(board, BoardDTO.class))
                .collect(Collectors.toList());

        // then
//        boardDTOList.stream().forEach(boardDTO -> assertThat(boardDTO.getTitle()).isEqualTo(board1.getTitle()));
    }
}
