package com.ccbcfx.learn.util;

import com.ccbcfx.learn.exception.UnloginException;


/**
 * @Description:
 * @Author: 陆志庆
 * @CreateDate: 2019/3/5 19:09
 */
public class UserUtil {
    private final static ThreadLocal<Integer> threadLocalUser = new ThreadLocal<>();
    public static final String KEY_USER = "user";

    public static void setUser(Integer userId) {
        threadLocalUser.set(userId);
    }

    public static Integer getUserIfLogin() {
        return threadLocalUser.get();
    }

    public static Integer getUser() {
        Integer user = threadLocalUser.get();
        if (user == null) {
            throw new UnloginException();
        }
        return user;
    }

    public static void clearUserInfo() {
        threadLocalUser.remove();
    }
}
