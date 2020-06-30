package com.study.corejava.aopjiangji;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class Ann {
    //定义切入点
    @Pointcut("@annotation(com.study.corejava.aopjiangji.AnnSelf)")
    public void auditAspect() {
        System.out.println("qiedian");
    }
    //通知
    @Before("auditAspect()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("触发到 @Before(\"auditAspect()\")");
        System.out.println(joinPoint.getArgs());

    }
    /**
     * 获取注解中对方法的描述信息
     *
     * @param joinPoint 切点
     * @return 方法描述
     */
    public static void getControllerMethodDescription(JoinPoint joinPoint) {
        String targetName = joinPoint.getTarget().getClass().getName();    //获得执行方法的类名
        String methodName = joinPoint.getSignature().getName();            //获得执行方法的方法名
        Object[] arguments = joinPoint.getArgs();                          //获取切点方法的所有参数类型
        try {
            Class targetClass = Class.forName(targetName);

            Method[] methods = targetClass.getMethods();    //获取公共方法，不包括类私有的
            String value = "";
            String name = "";
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();     //对比方法中参数的个数
                    if (clazzs.length == arguments.length) {
                        value = method.getAnnotation(AnnSelf.class).value();
                        name = method.getAnnotation(AnnSelf.class).name();
                        break;
                    }
                }
            }
            System.out.println("value=" + value);
            System.out.println("name=" + name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
