package basic.basiccrud.service;

import basic.basiccrud.entity.Member;
import basic.basiccrud.exception.MemberValidateException;
import basic.basiccrud.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
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
        Optional<Member> result = memberRepository.findByMemUserid(userId);
        if (!result.isEmpty()) {
            throw new MemberValidateException("이미 존재하는 아이디입니다.");
        }
    }

    /**
     * 로그인
     */
    @Transactional
    public Optional<Member> signIn(Member member) throws MemberValidateException {
        Optional<Member> findMember = memberRepository.findByMemUserid(member.getMemUserid());
        if (!findMember.isPresent()) {
            findMember.orElseThrow(() -> new MemberValidateException("아이디가 올바르지 않습니다."));
            return Optional.empty();
        }

        if (!findMember.get().getMemPwd().equals(member.getMemPwd())) {
            findMember.orElseThrow(() -> new MemberValidateException("비밀번호가 올바르지 않습니다."));
            return Optional.empty();
        }

        return findMember;
    }

    /**
     * 회원조회
     */
    @Transactional(readOnly = true)
    public Optional<Member> findById(Long id) {
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
