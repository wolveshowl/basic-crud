package basic.basiccrud.service;

import basic.basiccrud.entity.AuthLevel;
import basic.basiccrud.entity.Member;
import basic.basiccrud.exception.MemberValidateException;
import basic.basiccrud.repository.MemberRepository;
import basic.basiccrud.repository.MemberRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class MemberServiceTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepositoryImpl memberRepository;


    @Test
    @DisplayName("회원가입 테스트")
    void signup() {
        Member member = new Member();
        member.setMemUsername("조남근");
        member.setMemGender('M');
        member.setMemAge(32);
        member.setMemHp("01044293517");
        member.setMemPwd("123123");
        member.setMemNickname("jnk");
        member.setMemIpAddr("127.0.0.1");
        member.setMemRegdate(LocalDateTime.now());
        member.setMemLastLogDate(LocalDateTime.now());
        member.setMemLevel(AuthLevel.manager);

        try {
            Long savedMember = memberService.signUp(member);
            assertEquals(member, memberRepository.findById(savedMember));
        } catch (MemberValidateException e) {
            log.info("중복 회원 예외 발생");
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("중복 검증")
    void validateException() {

    }
}