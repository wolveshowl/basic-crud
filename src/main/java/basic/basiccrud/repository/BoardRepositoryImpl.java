package basic.basiccrud.repository;

import basic.basiccrud.dto.BoardDto;
import basic.basiccrud.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {

    private final EntityManager em;

    @Override
    public List<Board> findAll() {
        return em.createQuery("select b from Board b order by b.id DESC", Board.class)
                .getResultList();
    }

    @Override
    public Optional<Board> findById(Long id) {
        Board board = em.find(Board.class, id);
        return Optional.ofNullable(board);
    }

    @Override
    public Long save(Board board) {
        em.persist(board);
        return board.getId();
    }
}
