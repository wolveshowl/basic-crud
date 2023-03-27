package basic.basiccrud.controller;

import basic.basiccrud.dto.MemberDto;
import basic.basiccrud.entity.Member;
import basic.basiccrud.exception.MemberValidateException;
import basic.basiccrud.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder encoder;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("member", new MemberDto());
        return "members/signInForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDto memberDto, HttpServletRequest request) {
        Member member = Member.builder()
                .memUserid(memberDto.getMemUserId())
                .memPwd(memberDto.getMemPwd())
                .build();

        try {
            memberService.signIn(member);
            log.info("member={}", member.getMemUserid());

        } catch (MemberValidateException e) {
            throw new RuntimeException(e);
        }



        return "redirect:/board";
    }

    @GetMapping("/signup")
    public String signup() {
        return "members/memberSignUpForm";
    }
}
