package basic.basiccrud.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Member {


    @Id
    @GeneratedValue
    @Column(name = "mem_id")
    private Long id;

    @Column(length = 30)
    private String memUserid;
    @Column(length = 20)
    private String memUsername;
    @Column(length = 30)
    private String memPwd;
    @Column(length = 20)
    private String memNickname;
    @Column(length = 20)
    private String memHp;
    @Column(length = 1)
    private char memGender;
    private int memAge;
    private LocalDateTime memRegdate;
    @Column(length = 20)
    private String memIpAddr;
    private LocalDateTime memLastLogDate;

//    mem_id			일련번호(PK)		bigint
//    mem_userid		회원아이디		varchar(30)
//    mem_username	회원 이름			varchar(20)
//    mem_passwd	회원 비밀번호		varchar(30)
//    mem_nickname	회원 닉네임		varchar(20)
//    mem_hp			회원 전화번호		varchar(20)
//    mem_gender		회원 성별			char(1)
//    mem_age		회원 나이			int(3)
//    mem_regdate	회원 생성일자		datetime
//    mem_ip			회원 아이피주소		varchar(20)
//    mem_lastLogin	회원 최종접속일		datetime
}
