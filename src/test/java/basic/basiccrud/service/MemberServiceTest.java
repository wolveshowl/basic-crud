package basic.basiccrud.service;

import basic.basiccrud.entity.Member;
import basic.basiccrud.exception.MemberValidateException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static basic.basiccrud.entity.UserRole.manager;

@SpringBootTest
@Transactional
@Slf4j
class MemberServiceTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepositoryImpl memberRepository;






    @Test
    @DisplayName("로그인 테스트")
    void loginTest() throws MemberValidateException {
        //given
        Member member = Member.builder()
                .memUserid("dipper25")
                .memUsername("조남근")
                .memGender('M')
                .memPwd("123124")
                .memNickname("jnk")
                .memRegdate(LocalDateTime.now())
                .role(manager).build();


        memberService.signUp(member);
        //when
        Optional<Member> signedMember = memberService.signIn(member);
        //then
        log.info("signedMember={}", signedMember.get().toString());
    }
}