package com.example.fastlms.member.service;

import com.example.fastlms.member.entity.Member;
import com.example.fastlms.member.model.MemberInput;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {
    boolean register(MemberInput parameter);

    boolean emailAuth(String uuid);

}
