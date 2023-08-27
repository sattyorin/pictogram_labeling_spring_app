package pictolabeling.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * This is LoggingAspect class.
 */
@Aspect
@Component
public class LoggingAspect {

  /**
   * This is logBeforeController.
   *
   * @param joinPoint joinPoint
   */
  @Before("execution(* pictolabeling.controller..*(..))")
  public void logBeforeController(JoinPoint joinPoint) {
    // TODO(sara): use logger
    System.out
        .println("Before executing controller method : " + joinPoint.getSignature().getName());
  }

  /**
   * This is logAfterController.
   *
   * @param joinPoint joinPoint
   */
  @After("execution(* pictolabeling.controller..*(..))")
  public void logAfterController(JoinPoint joinPoint) {
    // TODO(sara): use logger
    System.out.println("After executing controller method : " + joinPoint.getSignature().getName());
  }

}
