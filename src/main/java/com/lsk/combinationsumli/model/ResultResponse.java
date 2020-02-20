package com.lsk.combinationsumli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 结果集
 * @author JoJo
 * @date 2020/02/16 18:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponse implements Serializable {

    /**
     * 成功结果
     */
    public static final int SUCCESS = 1;

    /**
     * 失败结果
     */
    public static final int FAIL = 0;

    /**
     * 结果代码
     */
    private int code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 结果
     */
    private Object result;

    /**
     * 是否成功
     * @return true OR false
     */
    public boolean isSuccess() {
        return code > FAIL;
    }
}
