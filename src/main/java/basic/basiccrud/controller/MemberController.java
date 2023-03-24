package basic.basiccrud.controller;

import basic.basiccrud.dto.MemberDto;
import basic.basiccrud.entity.Member;
import basic.basiccrud.exception.MemberValidateException;
import basic.basiccrud.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
//@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostConstruct
    public void init() {
        Member member = MemberDto.builder()
                .memUserId("test")
                .memPwd("1234")
                .build().login();

        try {
            memberService.signUp(member);
        } catch (MemberValidateException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("signMemberDto", new MemberDto());
        return "members/memberLoginForm";
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
            HttpSession session = request.getSession();


        } catch (MemberValidateException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/board/";
    }

}
