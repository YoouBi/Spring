package kr.co.greenart.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	private static final Logger logger = LoggerFactory.getLogger(MyAspect.class);

	@Pointcut("execution(* kr.co.greenart.model.file.FileDBRepository.getAllnames(..))")
	public void print() {}
	
	@Pointcut("within(@org.springframework.stereotype.Repository *)") // @로 대상이 되는 특정 타입의 제약을 줄 수 있다.
	// 앞과 뒤에 골뱅이를 붙일 수 있는데 어디에 붙이느냐에 따라 의미가 달라진다
	// 지금 붙인게 뜻하는건 이 어노테이션을 붙인 모든 클래스의 모든 메소드
	public void repository() {}
	
	@Around("repository()")
	public Object loggingTime(ProceedingJoinPoint jp) throws Throwable {
		long start = System.nanoTime(); // 이렇게 위에 적으면 메소드 전
		logger.info("시작 시간 : " + start);
		Object proceed =  jp.proceed(); // jp.proceed() 얘가 실제 실행되는 메소드인데 자체가 오브젝트를 반환함
		long end = System.nanoTime();
		logger.info("종료 시간 : " + end);
		
		logger.info(jp.getSignature().getName() + "메소드의 실행시간 : " + (end - start));
		return proceed;
	}
	
	@Before("print()")
	public void printBefore() {
		
	}
	
	@After("print()")
	public void printAfter() {
		
	}
	
//	// 접근 제한자 리턴타입 패키지.클래스.메소드(파라미터)
//	// 원래 public void였던걸 지우고 *로 씀
//	// 왜냐? 접근 제한자와 리턴 타입까지 써야하는데 보통은 구분자로 쓸 이유가 없다보니까 *로 쓴다
//	@Before("execution(* kr.co.greenart.model.file.FileDBRepository.getAllnames(..))")
//	// execution은 실행 시에 @Before는 전에 @After는 실행 후에
//	// ()은 파라미터 전달받는건데 ..은 아무 파라미터나
//	public void printBefore() {
//		logger.info("-- 파일 목록을 불러 오기 전에 실행됩니다. --");
//	}
//	
//	@After("execution(* kr.co.greenart.model.file.FileDBRepository.getAllnames(..))") // @After는 실행 후에
//	public void printAfter() {
//		logger.info("-- 파일 목록을 불러온 후에 실행됩니다. --");
//	}
}
