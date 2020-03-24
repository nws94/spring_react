package com.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entity.Test;
import com.backend.repo.TestJpaRepo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController // 결과값을 JSON으로 출력합니다.
@RequestMapping(value = "/api")
public class TestController {
	private final TestJpaRepo testJapRepo;
	
	@GetMapping(value = "/test")
	public List<Test> list() {
		return testJapRepo.findAll();
	}

 }