package springboard.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter @Setter
public class BoardForm {

    @NotEmpty(message = "제목은 필수입니다")
    private String title;
    private String writer;
    private String content;
    private LocalDateTime regDate;
}
