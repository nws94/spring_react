package com.backend.model.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//여러개의 결과를 담을 모델
public class ListResult<T> extends CommonResult {
    private List<T> list;
}