package basic.basiccrud.repository;

import basic.basiccrud.entity.Board;

import java.util.List;

public interface BoardQueryRepository {
    List<Board> findBoards();
}
