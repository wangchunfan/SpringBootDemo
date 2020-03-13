package wang.chunfan.springbootdemo.aop.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface LogJoinPoint {
    String value() default "default";
}
