package com.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entity.Board;

public interface BoardJpaRepo extends JpaRepository<Board, Long> {
	Board findByName(String name);
}
