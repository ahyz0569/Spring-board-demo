package springboard.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceImplTest {

    @Autowired
    BoardService boardService;

    @Test
    @Transactional
    void getPageList() {

        Integer[] pageList = boardService.getPageList(1);
        for (Integer integer : pageList) {
            System.out.println("integer = " + integer);
        }
        System.out.println("pageList.length = " + pageList.length);

    }
}