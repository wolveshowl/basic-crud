package basic.basiccrud.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_id")
    private Long id;

    @Column(length = 30, nullable = false, unique = true)
    private String memUserid;

    @Column(length = 20, nullable = false)
    private String memUsername;

    @Column(length = 30, nullable = false)
    private String memPwd;

    @Column(length = 20, nullable = false)
    private String memNickname;

    @Column(length = 20, nullable = false)
    private String memHp;

    @Column(length = 1, nullable = false)
    private char memGender;

    private int memAge;

    @Enumerated(EnumType.STRING)
    private AuthLevel memLevel;

    private LocalDateTime memRegdate;

    @Column(length = 20)
    private String memIpAddr;

    private LocalDateTime memLastLogDate;

}
