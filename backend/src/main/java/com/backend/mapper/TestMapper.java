package com.backend.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;
import com.backend.vo.TestVO;

@Repository
@Mapper
public interface TestMapper {
	
	List<TestVO> selectTest() throws Exception;

}