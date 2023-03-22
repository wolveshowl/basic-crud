package basic.basiccrud.service;

import basic.basiccrud.entity.Member;
import basic.basiccrud.exception.MemberValidateException;
import basic.basiccrud.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원가입
     */
    @Transactional
    public Long signUp(Member member) throws MemberValidateException {
        validateDuplicateMember(member.getMemUserid());
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 회원 중복 검증
     */
    private void validateDuplicateMember(String userId) throws MemberValidateException {
        Member result = memberRepository.findByMemId(userId);
        if (result != null) {
            throw new MemberValidateException("이미 존재하는 아이디입니다.");
        }
    }

    /**
     * 로그인
     */
    @Transactional
    public void signIn(Member member) {

    }

    /**
     * 회원조회
     */
    @Transactional(readOnly = true)
    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    /**
     * 회원 전체조회
     */
    @Transactional(readOnly = true)
    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
