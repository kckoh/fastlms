package com.example.fastlms.member.controller;

import com.example.fastlms.member.entity.Member;
import com.example.fastlms.member.model.MemberInput;
import com.example.fastlms.member.repository.MemberRepository;
import com.example.fastlms.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;


    @GetMapping("/member/register")
    public String register() {
        log.info("Request@@@");
        return "member/register";
    }

    @PostMapping("/member/register")
    public String registerSubmit(Model model, MemberInput memberInput) {

        boolean result = memberService.register(memberInput);
        model.addAttribute("result", result);
        return "member/register_complete";

    }

    @GetMapping("/member/email-auth")
    public String emailAuth(Model model, HttpServletRequest request) {
        String uuid = request.getParameter("id");
        boolean result = memberService.emailAuth(uuid);
        model.addAttribute("result", result);

        return "/member/email_auth";
    }


    @GetMapping("/member/info")
    public String memberInfo() {
        return "/member/info";
    }

    @RequestMapping("/member/login")
    public String memberLogin() {
        return "/member/login";
    }



}
