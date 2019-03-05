package com.ccbcfx.learn.filter;

import com.ccbcfx.learn.util.UserUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description:
 * @Author: 陆志庆
 * @CreateDate: 2019/3/5 19:06
 */
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        fillUserInfo((HttpServletRequest) servletRequest);
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            clearUserInfo();
        }
    }

    @Override
    public void destroy() {

    }

    private void clearUserInfo() {
        UserUtil.clearUserInfo();
    }

    private void fillUserInfo(HttpServletRequest request) {
        Integer user = getUserFromSession(request);
        if (user != null) {
            UserUtil.setUser(user);
        }


    }

    private Integer getUserFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }
        // 从session中获取用户信息放到工具类中
        return (Integer) session.getAttribute(UserUtil.KEY_USER);
    }
}
