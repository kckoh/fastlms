package com.example.fastlms.main.controller;

import com.example.fastlms.components.MailComponents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MailComponents mailComponents;

    @RequestMapping("/")
    public String index() {
        String email = "kyungcheolkoh@naver.com";
        String subject = "Hello. This is for test";
        String text = "<p>Hello world!</p> ";
//        mailComponents.sendMail(email,subject,text);
        return "index";
    }

}
