package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/handle")
public class HandlerMethodArgs {
	@GetMapping("/cookie")
	public @ResponseBody String args(@CookieValue(name = "JSESSIONID") String jsessionid) {
		// 이름과는 다르게 어트리뷰트 값에 이름을 써준다
		return jsessionid;
	}
	
	@GetMapping("/header")
	public @ResponseBody String head(@RequestHeader("Accept") String accept) {
		return accept;
	}
	
	// 추가적으로 api 구현할 때 많이 쓸 수 있는 표현으로
	@GetMapping("/{path1}/{path2}") // 주소 자체를 변수처럼 사용하기 위한 요청으로
	public @ResponseBody String paths(@PathVariable String path1, @PathVariable String path2) {
		// @PathVariable String path1의 path1 이름을 원하는 것으로 하거나
		// @PathVariable(name="")을 준다
		// 이러면 주소 uri를 자르는 작업과정없이 바로바로 쓸 수 있다
		return path1 + path2;
	}
	// String값만이 아니라 다른 것보 받아서 바...인딩? 처리하는 걸 만들어서...뭘 할 순 있겠지만
	// 주소에 너무 어려운 표현을 많이 주고받으면 힘들어지니까 주소는 간단하게!
}