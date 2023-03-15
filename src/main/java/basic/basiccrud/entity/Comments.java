package basic.basiccrud.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Comments {

    @Id
    @GeneratedValue
    @Column(name = "co_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mem_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bo_id")
    private Board board;

    @Column(length = 200, nullable = false)
    private String coContent;
    @Column(length = 1)
    private char coSecret;


//    co_id			일련번호(PK)		bigint
//    co_mem_id		회원 일련번호(FK)	bigint
//    co_bo_id			게시글 일련번호(FK)	bigint
//    co_content		댓글 내용			varchar(200)
//    co_secret		댓글 공개여부		char(1)
}
