package basic.basiccrud.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bo_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mem_id")
    private Member member;
    @Column(nullable = false)
    private String boWriter;
    @Column(nullable = false, length = 50)
    private String boTitle;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String boContent;
    @Column(length = 200)
    private String boFile;
    private int boHits;
    @Column(length = 1, nullable = false)
    private char boSecret;
    private LocalDateTime boCreated;
    private LocalDateTime boModified;


}
