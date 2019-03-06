package com.ccbcfx.learn.aop;

import com.ccbcfx.learn.bean.ResultBean;
import com.ccbcfx.learn.exception.BaseException;
import com.ccbcfx.learn.exception.ErrorCode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: 陆志庆
 * @CreateDate: 2019/3/5 17:36
 */
@Aspect
@Configuration
public class ControllerAop {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAop.class);

    /**
     * aop切面
     */
    @Pointcut("execution(public com.ccbcfx.learn.bean.ResultBean *(..))")
    public void executeService() {
    }

    /**
     * contoller 切面拦截方法
     *
     * @param thisJoinPoint
     * @return
     */
    @Around("executeService()")
    public Object handlerControllerMethod(ProceedingJoinPoint thisJoinPoint) {
        long startTime = System.currentTimeMillis();
        ResultBean<?> result;
        try {
            result = (ResultBean<?>) thisJoinPoint.proceed();
            long elapsedTime = System.currentTimeMillis() - startTime;
            logger.info("[{}]use time: {}", thisJoinPoint.getSignature(), elapsedTime);
        } catch (Throwable e) {
            result = handlerException(thisJoinPoint, e);
        }
        return result;
    }

    /**
     * 异常处理
     *
     * @param pjp
     * @param e
     * @return
     */
    private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ResultBean<?> result = new ResultBean();

        // 已知异常
        if (e instanceof BaseException) {
            result.setMsg(e.getLocalizedMessage());
            result.setCode(((BaseException) e).getErrorCode());
        }
        // 未知异常
        else {
            logger.error(pjp.getSignature() + " error ", e);
            result.setMsg(e.toString());
            result.setCode(ErrorCode.UNKNOWN_EXCEPTION);
        }
        return result;
    }
}
