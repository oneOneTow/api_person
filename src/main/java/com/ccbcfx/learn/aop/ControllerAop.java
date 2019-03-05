package com.ccbcfx.learn.aop;

import com.ccbcfx.learn.bean.ResultBean;
import com.ccbcfx.learn.exception.CheckException;
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

    @Pointcut("execution(public com.ccbcfx.learn.bean.ResultBean *(..))")
    public void excuteService(){}
    @Around("excuteService()")
    public Object handlerControllerMethod(ProceedingJoinPoint thisJoinPoint){
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

    private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ResultBean<?> result = new ResultBean();

        // 已知异常
        // 校验出错，参数非法
        if (e instanceof CheckException
                || e instanceof IllegalArgumentException) {
            result.setMsg(e.getLocalizedMessage());
            result.setCode(ResultBean.CHECK_FAIL);
        }
        else {
            logger.error(pjp.getSignature() + " error ", e);
            result.setMsg(e.toString());
            result.setCode(ResultBean.UNKNOWN_EXCEPTION);
        }
        return result;
    }
}
