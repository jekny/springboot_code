package com.hyw.springboot008.result;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * ClassName: Result
 * Description:
 *
 * @Author jekny
 * @Create 2026/9/5 19:16
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;
    
}
