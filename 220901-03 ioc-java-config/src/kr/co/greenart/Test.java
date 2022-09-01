package kr.co.greenart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("component-scan.xml");
//		MyDataRepository repo = context.getBean("myset", MyDataRepository.class);
//		// 인터페이스를 달라고하면 구현체를 준다
//		
//		System.out.println(repo.getMyNumbers());
		
		MyService service = context.getBean(MyService.class);
		System.out.println(service.numberService());
	}
}