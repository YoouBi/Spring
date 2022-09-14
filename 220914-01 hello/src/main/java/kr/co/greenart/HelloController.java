package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	// value로 사용자 요청의 주소값을 매핑해줄 수 있다 method로 요청 방식
	public String hello() {
		return "hello";		
	}
	
	@RequestMapping(value="/hi", method=RequestMethod.GET)
	public String hi() {
		return "hello";
	}
}