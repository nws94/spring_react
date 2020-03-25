package com.backend.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.backend.advice.exception.CUserNotFoundException;
import com.backend.repo.UserJpaRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
//토큰에 세팅된 유저 정보로 회원정보를 조회하는 UserDetailsService를 재정의 
public class CustomUserDetailService implements UserDetailsService{
	
	private final UserJpaRepo userJpaRepo;
	 
    public UserDetails loadUserByUsername(String userPk) {
        return (UserDetails) userJpaRepo.findById(Long.valueOf(userPk)).orElseThrow(CUserNotFoundException::new);
    }
}
