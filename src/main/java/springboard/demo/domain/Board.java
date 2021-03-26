package springboard.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static lombok.AccessLevel.*;

@Entity
@Getter @Setter(value = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String writer;
    private String content;
    private LocalDateTime regDate;

    // == 생성 메서드 == //
    public static Board createBoard(String title, String writer, String content) {
        Board board = new Board();
        board.setTitle(title);
        board.setWriter(writer);
        board.setContent(content);
        board.setRegDate(LocalDateTime.now());

        return board;
    }

    // == 수정 메서드 == //
    public void updateBoard(String title, String content) {
        this.title = title;
        this.content = content;
//        this.regDate = LocalDateTime.now();
    }

}
