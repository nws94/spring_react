package com.backend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entity.Board;
import com.backend.entity.Post;

public interface PostJpaRepo extends JpaRepository<Post , Long> {
	List<Post> findByBoard(Board board);
}
