package basic.basiccrud.repository;

import basic.basiccrud.entity.Board;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class BoardQueryRepositoryImpl implements BoardQueryRepository {

    private final EntityManager em;

    @Override
    public List<Board> findBoards() {
        return null;
    }
}
