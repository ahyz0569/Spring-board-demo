package springboard.demo.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import springboard.demo.dto.BoardDTO;
import springboard.demo.service.BoardService;
import springboard.demo.dto.BoardForm;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

    // 게시물 생성뷰
    @GetMapping("/board/new")
    public String createBoardForm(Model model) {
        LOGGER.info("createBoardForm");

        model.addAttribute("boardForm", new BoardForm());
        return "board/createBoardForm";
    }

    // 게시물 생성
    @PostMapping("/board/new")
    public String create(@Valid BoardForm boardForm, BindingResult result) {
        LOGGER.info("create");

        if (result.hasErrors()) {
            return "board/createBoardForm";
        }
        boardService.uploadPost(boardForm);
        return "redirect:/board/list";
    }

    // 게시물 목록
    @GetMapping("/board/list")
    public String list(Model model) {
        LOGGER.info("list");

        model.addAttribute("postList", boardService.list());
        return "board/list";
    }

    // 게시물 조회
    @GetMapping("/board/readView")
    public String read(BoardDTO boardDTO, Model model) {
        LOGGER.info("read");

        BoardDTO findPost = boardService.read(boardDTO.getId());
        model.addAttribute("post", findPost);
        return "board/readView";
    }

    // 게시물 수정 뷰
    @GetMapping("/board/{postId}/edit")
    public String updateBoardForm(@PathVariable("postId") Long postId, Model model) {
        LOGGER.info("updateBoardForm");

        BoardDTO updatePost = boardService.read(postId);
        model.addAttribute("updatePost", updatePost);
        return "board/updateView";
    }

    // 게시물 수정
    @PostMapping("/board/{postId}/edit")
    public String updateBoard(@PathVariable("postId") Long postId,
                              @Valid @ModelAttribute("updatePost") BoardDTO boardDTO,
                              BindingResult result) {
        LOGGER.info("updateBoard");

        if (result.hasErrors()) {
            return "board/updateView";
        }

        boardService.updatePost(boardDTO);
        return "redirect:/board/list";
    }

    // 게시물 삭제 뷰
    @PostMapping("/board/delete")
    public String delete(BoardDTO boardDTO) {
        LOGGER.info("delete");

        boardService.deletePost(boardDTO.getId());
        return "redirect:/board/list";
    }
}
