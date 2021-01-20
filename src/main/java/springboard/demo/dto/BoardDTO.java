package springboard.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class BoardDTO {
    private Long id;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime regDate;
}
