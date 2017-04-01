/**
 * www.tydic.com Inc.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package com.tydic.base.core.service.support.aop;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import com.tydic.base.core.common.enums.BizErrorCode;
import com.tydic.base.core.common.exception.ServiceException;
import com.tydic.base.core.common.exception.ValidationException;
import com.tydic.base.core.common.validator.ValidatorImpl;
import com.tydic.base.core.service.api.base.BaseReqDto;
import com.tydic.base.core.service.support.exception.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * 统一数据校验，日志打印，以及异常数据
 * @author tianshuo
 * @version Id: BaseCoreAspect.java, v 0.1 2016/7/27 0027 19:06 tianshuo Exp $$
 */
@Component
@Aspect
@Slf4j
public class BaseCoreAspect {
    @Resource
    private ValidatorImpl validator;

    /**
     * 调用启动服务
     * @param joinPoint 切点
     */
    @Before("execution(* com.tydic.base.core.service..*.*Impl.*(..))")
    public void logBefore(JoinPoint joinPoint){
        String clazzName = joinPoint.getTarget().getClass().getSimpleName();   //获得类名
        String methodName = joinPoint.getSignature().getName();   //获得方法名
        Object[] args = joinPoint.getArgs();  //获得参数列表
        BaseReqDto baseReqDto;
        if (args != null && args.length > 0) {
            if(args[0] != null && args[0] instanceof BaseReqDto){
                baseReqDto = (BaseReqDto)args[0];
                log.info("[{}] [{}.{}] Start to handle request .\n[{}]", baseReqDto.getTraceLogId(),
                        clazzName, methodName, baseReqDto.toString());
            }else{
                log.info("[{}] [{}.{}] Start to handle request .\n[{}]",null,
                        clazzName, methodName, getLog(args));
            }
        }
    }

    /**
     * 服务结束时调用
     * @param joinPoint 切点
     * @param reponse 响应
     */
    @AfterReturning(value ="execution(* com.tydic.base.core.service..*.*Impl.*(..))",returning = "reponse")
    public void logAfterRunning(JoinPoint joinPoint, Object reponse){
        String clazzName = joinPoint.getTarget().getClass().getSimpleName();   //获得类名
        String methodName = joinPoint.getSignature().getName();   //获得方法名
        String initiationId = null;
        Object[] args = joinPoint.getArgs();  //获得参数列表
        if(args != null && args.length > 0 && (args[0] != null && args[0] instanceof BaseReqDto)){
            initiationId = ((BaseReqDto)args[0]).getTraceLogId();
        }
        log.info("[{}] [{}.{}] Finish handling reponse .\n {}.",initiationId,clazzName,methodName,reponse == null?"":reponse.toString());
    }

    /**
     * 入参校验，异常封装
     * @param joinPoint 切点
     */
    @SuppressWarnings("unused")
    @Around(value = "com.tydic.base.core.service.support.aop.BaseCoreAspect.servicePointcut()")
    public Object handleException(ProceedingJoinPoint joinPoint) {
        String clazzName = joinPoint.getTarget().getClass().getSimpleName();   //获得类名
        String methodName = joinPoint.getSignature().getName();   //获得方法名
        String initiationId = null;
        Object[] args = joinPoint.getArgs();  //获得参数列表
        if(args != null && args.length > 0 && (args[0] != null && args[0] instanceof BaseReqDto)){
            initiationId = ((BaseReqDto)args[0]).getTraceLogId();
        }
        Object obj = null;
        try {
            int length = args.length;
            //如果有请求参数，则规则校验属性
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    validator.validate(args[i]);
                }
            }
            obj = joinPoint.proceed();
        } catch (ValidationException e) {
            log.warn("[{}] [{}.{}] validator failed,cause:{}",initiationId,clazzName,methodName, e);
            return ExceptionHandler.handle(new ServiceException(BizErrorCode.PARAMETER_VALID_NOT_PASS_BY, e.getMessage(), e));
        }catch (Throwable throwable) {
            log.error("[{}] [{}.{}] Finish handling request \n[{}].\nSome Exception Occur:[{}]",initiationId,
                    clazzName, methodName,args == null ? "":getLog(args), throwable);
            return ExceptionHandler.handle(throwable);
        }

        return obj;
    }

    @Pointcut("execution(* com.tydic.base.core.service..*.*Impl.*(..))")
    void servicePointcut() {
    }

    private String getLog(Object[] args){
        StringBuffer logSb = new StringBuffer("[");
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            logSb.append(arg == null ? null : arg.toString());
            if(i != args.length-1){
                logSb.append(",");
            }
        }
        logSb.append("]");
        return logSb.toString();
    }
}
