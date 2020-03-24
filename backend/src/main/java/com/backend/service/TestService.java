package com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.mapper.TestMapper;
import com.backend.vo.TestVO;

@Service
public class TestService {
	@Autowired
	public TestMapper mapper;
	
	public List<TestVO> selectTest() throws Exception {
		return mapper.selectTest();
	}
}
