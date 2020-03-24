package com.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entity.Test;

public interface TestJpaRepo extends JpaRepository<Test, Long> {
	
	
}
