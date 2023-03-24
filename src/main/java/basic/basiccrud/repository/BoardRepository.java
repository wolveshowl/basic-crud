package basic.basiccrud.repository;

import basic.basiccrud.entity.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    List<Board> findAll();

    Optional<Board> findById(Long id);

    Long save(Board board);
}
