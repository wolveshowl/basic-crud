package basic.basiccrud.dto;

import basic.basiccrud.entity.Board;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {

    @NotNull
    private String boWriter;
    @NotNull
    private String boTitle;
    @NotNull
    private String boContent;
    private String boFile;
    @NotNull
    private int boHits;
    @NotNull
    private char boSecret;
    @NotNull
    private LocalDateTime boCreated;
    @NotNull
    private LocalDateTime boModified;

    public Board toEntity() {
        Board board = Board.builder()
                .boWriter(boWriter)
                .boTitle(boContent)
                .boFile(boFile)
                .boHits(boHits)
                .boSecret(boSecret)
                .boCreated(LocalDateTime.now())
                .boModified(LocalDateTime.now())
                .build();

        return board;
    }





}
