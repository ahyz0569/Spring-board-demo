package springboard.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springboard.demo.service.BoardService;
import springboard.demo.vo.BoardForm;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/new")
    public String createBoardForm(Model model) {
        model.addAttribute("boardForm", new BoardForm());
        return "board/createBoardForm";
    }

    @PostMapping("/board/new")
    public String create(@Valid BoardForm boardForm, BindingResult result) {
        if (result.hasErrors()) {
            return "board/createBoardForm";
        }
        boardService.uploadPost(boardForm);
        return "redirect:/board/list";
    }

    @GetMapping("/board/list")
    public String list(Model model) {
        model.addAttribute("list", boardService.list());
        return "board/list";
    }

}
