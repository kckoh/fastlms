package com.example.fastlms.components;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
@RequiredArgsConstructor
@Slf4j
public class MailComponents {

    private final JavaMailSender javaMailSender;

//    public void sendMailTest() {
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//
//        simpleMailMessage.setTo("kyungcheolkoh@naver.com");
//        simpleMailMessage.setSubject("Hello KC");
//        simpleMailMessage.setText("Hello world!");
//
//        javaMailSender.send(simpleMailMessage);
//    }

    public boolean sendMail(String mail, String subject, String text) {
        boolean result = false;
        MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                mimeMessageHelper.setTo(mail);
                mimeMessageHelper.setSubject(subject);
                mimeMessageHelper.setText(text, true);
            }
        };

        try {
            javaMailSender.send(mimeMessagePreparator);
            return result;
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error("Mail error has occurred");
        }

        return result;

    }

}
