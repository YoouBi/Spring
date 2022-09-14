package kr.co.greenart;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.co.greenart.model.User;

public class MyFirstTest {

	@Test
	public void test() {
//		fail("Not yet implemented"); // fail()은 무조건 실패하는 메소드로 junit 실행을 해보면 x표시가 뜬다
		int a = 10;
		int b = 20;
		
		int sum = a + b;
		assertEquals(30, sum); // 기대값과 실제값을 비교하여 같으면 통과하고 같지 않으면 실패로 알려준다
	}
	
	@Test
	public void test2() {
		String abc = "abc";
		String abc2 = abc;
		
		assertSame(abc2, abc);
	}
	
	@Test
	public void test3() {
		User u = new User();
		
		assertNotNull(u);
	}
}
