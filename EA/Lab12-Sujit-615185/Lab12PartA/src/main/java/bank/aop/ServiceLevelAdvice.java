package bank.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class ServiceLevelAdvice {
    @Around("execution(* bank.service.*.*(..))")
    public Object time(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();

        long totaltime=sw.getTotalTimeMillis();
        System.out.println("Duration of method "+call.getSignature().getName()+" execution is  = "+totaltime+" ms");

        return retVal;
    }
}
