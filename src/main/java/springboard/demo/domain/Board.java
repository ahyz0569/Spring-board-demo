package springboard.demo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.time.LocalDateTime;

import static lombok.AccessLevel.*;


@Entity
@Getter @Setter
@NoArgsConstructor(access = PROTECTED)
public class Board {

    @Id @GeneratedValue
    @JoinColumn(name = "board_id")
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

}
