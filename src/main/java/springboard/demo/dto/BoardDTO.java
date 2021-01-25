package springboard.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Getter @Setter
public class BoardDTO {
    private Long id;

    @NotEmpty(message = "제목은 필수입니다")
    private String title;
    private String writer;
    @NotEmpty(message = "내용을 입력해주세요")
    private String content;
    private LocalDateTime regDate;
}
