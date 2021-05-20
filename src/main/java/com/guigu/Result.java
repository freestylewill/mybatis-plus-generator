package com.guigu;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wzt
 */
@Builder
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String msg;

    private T data;

    public static Result<String> success() {
        return success(null);
    }

    public static <T> Result<T> success(T data) {
        return Result.<T>builder()
                .code(ResultCode.Success.getCode())
                .msg(ResultCode.Success.getMsg())
                .data(data)
                .build();
    }

    public static Result<String> fail(String msg) {
        return fail(ResultCode.Fail, msg);
    }

    public static <T> Result<T> fail(ResultCode resultCode, String msg) {
        return Result.<T>builder()
                .code(resultCode.getCode())
                .msg(msg)
                .build();
    }

}
