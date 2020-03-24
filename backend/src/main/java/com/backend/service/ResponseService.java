package com.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.model.response.CommonResult;
import com.backend.model.response.ListResult;
import com.backend.model.response.SingleResult;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Service
public class ResponseService {
	
	 // enum(열거형)으로 api 요청 결과에 대한 code, message를 정의합니다.
	@Getter
	@AllArgsConstructor
	public enum CommonResponse {
		SUCCESS(0, "성공하였습니다."),
		FAIL(-1,"실패하였습니다.");
		
		
		int code;
		String msg;
		
	}
	// 단일건 결과를 처리하는 메소드
	public <T> SingleResult<T> getSingleResult(T data) {
		SingleResult<T> result = new SingleResult<>();
		result.setData(data);
		setSuccessResult(result);
		return result;
	}
	// 다중건 결과를 처리하는 메소드
	public <T> ListResult<T> getListResult(List<T> list) {
		ListResult<T> result = new ListResult<>();
		result.setList(list);
		setSuccessResult(result);
		return result;
	}
	// 성공 결과만 처리하는 메소드
	public CommonResult getSuccessResult() {
		CommonResult result = new CommonResult();
		setSuccessResult(result);
		return result;
	}
	// 실패 결과만 처리하는 메소드
	public CommonResult getFailResult(int code, String msg) {
	    CommonResult result = new CommonResult();
	    result.setSuccess(false);
	    result.setCode(code);
	    result.setMsg(msg);
	    return result;
	}
	// 결과 모델에 api 요청 성공 데이터를 세팅해주는 메소드
	private void setSuccessResult(CommonResult result) {
		result.setSuccess(true);
		result.setCode(CommonResponse.SUCCESS.getCode());
		result.setMsg(CommonResponse.SUCCESS.getMsg());
	}
	
}
