package springboard.demo.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import springboard.demo.domain.Board;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository{

    @PersistenceContext
    private final EntityManager em;

    @Override
    public void write(Board board) {
        em.persist(board);
    }

    @Override
    public List<Board> findAll() {
        String jpql = "select b from Board b order by b.id desc";
        return em.createQuery(jpql, Board.class).getResultList();
    }

    @Override
    public Board findOne(Long id) {
        return em.find(Board.class, id);
    }

    @Override
    public void delete(Long id) {
        Board board = em.find(Board.class, id);
        em.remove(board);
    }
}
