package com.backend.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entity.User;

public interface UserJpaRepo extends JpaRepository<User, Long>{
	//회원 가입 시 가입한 이메일 조회를 위한 메서드
	Optional<User> findByUid(String email);
}
