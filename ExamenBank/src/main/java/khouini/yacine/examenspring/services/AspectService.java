package khouini.yacine.examenspring.services;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Aspect
@Component
public class AspectService {
     /*@Pointcut("execution(* khouini.yacine.examenspring.services..get*(..))")
    private void getMethods() {}*/
     private static final Logger log = LoggerFactory.getLogger(AspectService.class);

    //@After("getMethods()")
    @After("execution(* khouini.yacine.examenspring.services..get*(..))")
    public void afterGet() {
// Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Extract the date part (ignoring time)
        LocalDate currentDate = currentDateTime.toLocalDate();

        log.info("function get runned in " + currentDateTime);
    }
}
