package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//AOP는 @Aspect를 붙여줘야 스프링 컨테이너가 AOP로 인식한다.
@Aspect
@Component //AOP를 Bean으로 등록해줘야 한다.
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        System.out.println("START: "+joinPoint.toString());

        try {
            return joinPoint.proceed(); //joinPoint의 메서드가 실행된다.
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("END: "+joinPoint.toString()+" "+timeMs+"ms");
        }
    }
}
