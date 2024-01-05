package khouini.yacine.examenspring.services;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectService {
    private static final Logger log = LoggerFactory.getLogger(AspectService.class);

     /*@Pointcut("execution(* khouini.yacine.examenspring.services..get*(..))")
    private void getMethods() {}*/

    //@After("getMethods()")
    @After("execution(* khouini.yacine.examenspring.services..*(String, ..))")
    public void afterGet(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();

        log.info("method " + methodName + " runned success with string parameter");
    }
}
