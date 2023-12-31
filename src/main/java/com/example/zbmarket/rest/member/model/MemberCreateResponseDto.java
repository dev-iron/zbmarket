package com.example.zbmarket.rest.member.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class MemberCreateResponseDto {
    private String accessToken;
    private String refreshToken;
}
