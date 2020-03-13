package wang.chunfan.springbootdemo.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(wang.chunfan.springbootdemo.aop.anotation.LogJoinPoint)")
    public void logPointcut() {

    }

    @Around("logPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        try {
            Object object = joinPoint.proceed();
            System.out.println(method.getName() + " 执行完毕！");
            return object;
        } catch (Exception ex) {
            System.out.println(method.getName() + " 执行失败！");
            throw ex;
        }
    }
}
