package springboard.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter @Setter
public class BoardForm {

    @NotEmpty(message = "제목을 입력해주세요")
    private String title;
    @NotEmpty(message = "작성자를 입력해주세요")
    private String writer;
    @NotEmpty(message = "내용을 입력해주세요")
    private String content;
    private LocalDateTime regDate;
}
