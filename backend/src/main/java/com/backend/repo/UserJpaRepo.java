package com.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entity.User;

public interface UserJpaRepo extends JpaRepository<User, Long>{

}
