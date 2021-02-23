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

    private static final int BLOCK_PAGE_NUM_COUNT = 20; // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 10; // 한 페이지에 존재하는 게시글 수

    @Override
    @Transactional
    public Long uploadPost(BoardForm boardForm) {
        Board board = Board.createBoard(boardForm.getTitle(), boardForm.getWriter(), boardForm.getContent());
        boardRepository.write(board);
        return board.getId();
    }

    @Override
    public List<BoardDTO> list(Integer pageNum) {
//        List<Board> boardList = boardRepository.findAll();

        int startPosition = this.findStartPosition(pageNum);

        // findPerPage(Integer pageNum)를 통해 해당 페이지에 존재하는 BoardList 전달받기
        List<Board> boardList = boardRepository.findPerPage(startPosition, PAGE_POST_COUNT);
        return boardList.stream()
                .map(board -> modelMapper.map(board, BoardDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BoardDTO read(Long id) {
        Board board = boardRepository.findOne(id);
        return modelMapper.map(board, BoardDTO.class);
    }

    @Override
    @Transactional
    public void updatePost(BoardDTO boardDTO) {
        Board findPost = boardRepository.findOne(boardDTO.getId());
        findPost.updateBoard(boardDTO.getTitle(), boardDTO.getContent());
    }

    @Override
    @Transactional
    public void deletePost(Long id) {
        boardRepository.delete(id);
    }

    @Override
    public Long getBoardCount() {
        return boardRepository.count();
    }

    /*
    코드 출처: https://victorydntmd.tistory.com/333
     */
    @Override
    public Integer[] getPageList(Integer curPageNum) {
        Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

        // 총 게시글 갯수
        Double postsTotalCount = Double.valueOf(this.getBoardCount());

        // 총 게시글 기준으로 계산한 마지막 페이지 번호 계산(올림으로 계산)
        Integer totalLastPageNum = (int) (Math.ceil((postsTotalCount / PAGE_POST_COUNT)));

        // 현재 페이지를 기준으로 블럭의 마지막 페이지 번호 계산
        Integer blockLastPageNum = (totalLastPageNum > curPageNum + BLOCK_PAGE_NUM_COUNT)
                ? curPageNum + BLOCK_PAGE_NUM_COUNT
                : totalLastPageNum;

        // 페이지 시작 번호 조정
        curPageNum = (curPageNum <= 3) ? 1 : curPageNum - 2;

        // 페이지 번호 할당
        for (int val = curPageNum, idx = 0; val <= blockLastPageNum; val++, idx++) {
            pageList[idx] = val;
        }

        return pageList;
    }

    public int findStartPosition(Integer curPageNum){
        if (curPageNum == 1) {
            return 0;
        } else {
            return (curPageNum - 1) * PAGE_POST_COUNT;
        }
    }

}
