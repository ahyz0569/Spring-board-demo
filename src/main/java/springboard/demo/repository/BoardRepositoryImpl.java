package springboard.demo.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import springboard.demo.domain.Board;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository{

    @PersistenceContext
    private final EntityManager em;

    @Override
    public void write(Board board) {
        em.persist(board);
    }
}
