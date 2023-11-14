package aop1.aspects;

import aop1.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspects {
    @Pointcut("execution(* aop1.UniLibrary.get*(..))")
    private void allGetMethods(){}

    @Pointcut("execution(* aop1.UniLibrary.return*(..))")
    private void allReturnMethods(){}


    @Before("allGetMethods()")
    public void beforeAllGetMethodsLoggingAdvice(JoinPoint joinPoint) {
        System.out.println("beforeAllMethodsExceptReturnAdvice: " +
                "Logging Get method without Return");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Absolutely signature of method: " + methodSignature.getMethod());
        StringBuilder args = new StringBuilder();
        if (methodSignature.getName().equals("getBook")) {
            Object[] arg = joinPoint.getArgs();
            for (Object obj: arg) {
                if (obj instanceof Book myBook) {
                    args.append("Информация о книге:" + "\nНазвание - ")
                            .append(myBook.getName()).append("\nАвтор - ")
                            .append(myBook.getAuthor()).append("\nГод издания - ")
                            .append(myBook.getYearOfPublication());
                }
            }
        }
        System.out.println(args);
    }

    @Around("allReturnMethods()")
    public Object aroundAllReturnMethodsLoggingAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aroundAllReturnMethodsLoggingAdvice: start method " + pjp.getSignature().getName());
        StringBuilder args = new StringBuilder();
        for (Object obj: pjp.getArgs()) {
            if (obj instanceof Book myBook) {
                args.append("Информация о книге:" + "\nНазвание - ")
                        .append(myBook.getName()).append("\nАвтор - ")
                        .append(myBook.getAuthor()).append("\nГод издания - ")
                        .append(myBook.getYearOfPublication());
            }
        }
        System.out.println("Arguments: " + args);
        Object targetMethodResult = null;
        try {
            targetMethodResult = pjp.proceed();
        }
        catch (Exception e) {
            System.out.println("aroundAllReturnMethodsLoggingAdvice: Logging exception " + e);
        }

        System.out.println("aroundAllReturnMethodsLoggingAdvice: end method " + pjp.getSignature().getName());
        System.out.println("-------------------------------------------------");

        return targetMethodResult;
    }
}
