package basic.basiccrud.service;

import basic.basiccrud.dto.BoardDto;
import basic.basiccrud.entity.Board;
import basic.basiccrud.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> findBoardList() {
        List<Board> board = boardRepository.findAll();
        return board;
    }

    public Optional<Board> findById(Long id) {
        Optional<Board> board = boardRepository.findById(id);
        return board;
    }

    public Long write(BoardDto boardDto) {
        Board board = Board.builder()
                .boWriter(boardDto.getBoWriter())
                .boTitle(boardDto.getBoTitle())
                .boFile(boardDto.getBoFile())
                .boHits(boardDto.getBoHits())
                .boSecret(boardDto.getBoSecret())
                .boCreated(LocalDateTime.now())
                .boModified(LocalDateTime.now())
                .build();

        return boardRepository.save(board);

    }
}
