package com.lixin.aspect;

import com.alibaba.fastjson.JSON;
import com.lixin.annotation.MyMethodAnnotation;
import com.lixin.annotation.MyTypeAnnotation;
import com.lixin.exception.ParamsException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Component
@org.aspectj.lang.annotation.Aspect
public class TestAspect {

    /**
     * 目标是com.lixin包及其子包下所有的类的公共方法
     */
    @Pointcut("execution(public * com.lixin..*(..))")
    public void anyPublicMethod() {

    }

    /**
     * 目标是任何以say开头、任何返回类型的方法
     */
    @Pointcut("execution(* say*(..))")
    public void anySetMethod() {

    }

    /**
     * 目标是com.lixin.aspect.TestAop下的所有方法
     */
    @Pointcut("execution(* com.lixin.aspect.TestAop.*(..))")
    public void anyTestAopMethod() {

    }

    @Pointcut("execution(String com.lixin.aspect.TestAop.*(..))")
    public void anyStringReturnAopMethod() {

    }

    @Before("anyStringReturnAopMethod()")
    public void beforeTest() {
        System.out.println("before method");
    }

    @After("anyPublicMethod()")
    public void afterTest() {
        System.out.println("after method");
    }

    @AfterReturning(pointcut = "execution(int com.lixin.aspect.TestAop.returnInteger(..))",returning = "retVal")
    public void afterReturningTest(int retVal) {
        System.out.println("after return int:" + retVal);
    }

    @AfterThrowing(pointcut = "execution(* com.lixin.aspect.TestAop.*(..)))", throwing = "exception")
    public void afterThrowing(Exception exception) {
        if (exception instanceof ParamsException) {
            System.out.println(exception.getMessage());
        }else {
            System.out.println("其他异常");
        }
    }

    @Around("execution(* com.lixin.aspect.TestAop.arountExample(..))")
    public Object aroundExample(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before around");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("after around");
        return proceed;
    }

    @Around("anyTestAopMethod() && @annotation(myMethodAnnotation)")
    public Object aroundAnnotationExample(ProceedingJoinPoint proceedingJoinPoint, MyMethodAnnotation myMethodAnnotation) {
        Object proceed = null;
        System.out.println("before annotation");
        //获取注解值
        String value = myMethodAnnotation.value();
        System.out.println("value:" + value);
        try {
            Signature signature = proceedingJoinPoint.getSignature();
            //切入点的签名信息，包括切入类的类型、类名、切入方法的方法名、修饰类型
            //{
            //    "declaringType":"com.lixin.aspect.TestAop",
            //    "declaringTypeName":"com.lixin.aspect.TestAop",
            //    "exceptionTypes":[
            //
            //    ],
            //    "method":Object{...},
            //    "modifiers":1,
            //    "name":"annotation",
            //    "parameterNames":[
            //        "username",
            //        "password"
            //    ],
            //    "parameterTypes":[
            //        "java.lang.String",
            //        "java.lang.String"
            //    ],
            //    "returnType":"void"
            //}
            System.out.println("signature:" + JSON.toJSONString(proceedingJoinPoint.getSignature()));
            //切入类的类型
            System.out.println("DeclaringType:" + JSON.toJSONString(signature.getDeclaringType()));
            //切入类的类名
            System.out.println("DeclaringTypeName:" + JSON.toJSONString(signature.getDeclaringTypeName()));
            //切入方法的方法名
            System.out.println("Name:" + JSON.toJSONString(signature.getName()));
            //切入方法的修饰符
            System.out.println("Modifiers:" + JSON.toJSONString(signature.getModifiers()));
            //切入方法的参数列表  数组
            System.out.println("args:" + JSON.toJSONString(proceedingJoinPoint.getArgs()));
            //切入点执行的类型
            System.out.println("kind:" + JSON.toJSONString(proceedingJoinPoint.getKind()));
            Object[] objects = proceedingJoinPoint.getArgs();
            Annotation typeAnnotation = signature.getDeclaringType().getAnnotation(MyTypeAnnotation.class);
            System.out.println(JSON.toJSONString(typeAnnotation));
            proceed = proceedingJoinPoint.proceed();
            System.out.println("target:"+JSON.toJSONString(proceedingJoinPoint.getTarget()));

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after annotation");
        return proceed;
    }
}
