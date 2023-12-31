package com.example.zbmarket.rest.member;

import com.example.zbmarket.rest.member.model.*;
import com.example.zbmarket.service.member.AuthMemberService;
import com.example.zbmarket.service.member.model.DefaultToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class MemberController {
    private final AuthMemberService authMemberService;

    @PostMapping("/join")
    public MemberCreateResponseDto createMember(
            @RequestBody @Valid MemberCreateRequestDto memberCreateRequestDto) {
        DefaultToken created = authMemberService.createMember(
                memberCreateRequestDto.getEmail(),
                memberCreateRequestDto.getPassword()
        );
        return MemberCreateResponseDto.builder()
                .accessToken(created.getAccessToken())
                .refreshToken(created.getRefreshToken()).build();
    }

    @GetMapping("/who-am-i")
    public ResponseFindMemberDto findMember(Authentication authentication) {
        return ResponseFindMemberDto.builder()
                .email(authentication.getName())
                .build();
    }
}
