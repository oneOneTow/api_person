package com.ccbcfx.learn.bean;

import com.ccbcfx.learn.exception.ErrorCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: 陆志庆
 * @CreateDate: 2019/3/5 17:45
 */
@Data
public class ResultBean<T> implements Serializable {

    /**
     * 返回的信息(主要出错的时候使用)
     */
    private String msg = "success";

    /**
     * 接口返回码, 0表示成功, 其他看对应的定义
     * 晓风轻推荐的做法是:
     * 0   : 成功
     * >0 : 表示已知的异常(例如提示错误等, 需要调用地方单独处理)
     * <0 : 表示未知的异常(不需要单独处理, 调用方统一处理)
     */
    private int code = ErrorCode.SUCCESS;

    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        this.data = data;
    }

    public ResultBean(Throwable e) {
        this.msg = e.toString();
        this.code = ErrorCode.UNKNOWN_EXCEPTION;
    }


    /**
     * 返回的信息出错的时候使用
     */
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 接口返回码, 0表示成功, 其他看对应的定义
     * 晓风轻推荐的做法是:
     * 0   : 成功
     * >0 : 表示已知的异常(例如提示错误等, 需要调用地方单独处理)
     * <0 : 表示未知的异常(不需要单独处理, 调用方统一处理)
     */
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 返回的数据
     */
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
