package basic.basiccrud.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_id")
    private Long id;

    @Column(length = 30, nullable = false, unique = true)
    private String memUserid;

    @Column(length = 20)
    private String memUsername;

    @Column(length = 30, nullable = false)
    private String memPwd;

    @Column(length = 20)
    private String memNickname;

    @Column(length = 1)
    private char memGender;

    private LocalDateTime memRegdate;

    @Enumerated(EnumType.STRING)
    private Role role;




}
