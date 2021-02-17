package springboard.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import springboard.demo.domain.Board;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
class BoardRepositoryImplTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void findAll() {
    }

    @Test
    @Transactional
    void findPerPage() {

//        Board board = Board.createBoard("1", "11", "111");
//        boardRepository.write(board);
//
//        Board board2 = Board.createBoard("2", "22", "222");
//        boardRepository.write(board2);
//
//        Board one = boardRepository.findOne(board.getId());
//        System.out.println("one.getTitle() = " + one.getTitle());

        List<Board> perPage = boardRepository.findPerPage(120, 10);
        for (Board findBoard : perPage) {
            System.out.println("findBoard.getid() = " + findBoard.getId());
        }
        System.out.println("perPage.size() = " + perPage.size());
    }

    @Test
    public void count() throws Exception {
        // given
        Long count = boardRepository.count();
        System.out.println(count);
        // when

        // then
    }
}