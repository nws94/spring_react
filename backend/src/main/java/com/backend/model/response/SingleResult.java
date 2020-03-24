package com.backend.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//결과를 하나만 담는 모델
public class SingleResult<T> extends CommonResult {
	private T data;
}
