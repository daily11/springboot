package com.swust.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect//1 声明一个切面
@Component//2 让此切面成为Spring容器管理的Bean
public class LogAspect {

    @Pointcut("@annotation(com.swust.springboot.aop.Action)")//3 声明切点
    public void annotationPointCut() {};

    @After("annotationPointCut()")//4 声明一个建言，并使用@PointCut定义的切点
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);//5 通过反射获取注解上的属性
        System.out.println("注解式拦截输出：" + action.name());
        System.out.println("----------------------------------------");
    }

    /**
     * 定义切入点，切入点为com.swust.springboot.service下的所有函数
     */
    @Pointcut("execution(public * com.swust.springboot.service..*.*(..))")
    public void  executionPointCut() {};

    @Before("executionPointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截输出：" + method.getName());
    }

}
