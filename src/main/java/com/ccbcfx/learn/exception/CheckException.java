package com.ccbcfx.learn.exception;

/**
 * @Description: 校验异常
 * @Author: 陆志庆
 * @CreateDate: 2019/3/5 18:17
 */
public class CheckException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CheckException() {
    }

    public CheckException(String message) {
        super(message);
    }

    public CheckException(Throwable cause) {
        super(cause);
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
