package kr.co.greenart;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/returns")
public class ReturnTypesController {
	@GetMapping("/viename")
	public String viewname() {
		return "hello";
	}
	
	@GetMapping("/respbody")
	public @ResponseBody String body() { // @ResponseBody는 리턴타입 앞에 붙여도되고 위에 붙여도 된다
		return "body 내용";
	}
	
	@GetMapping("/mv")
	public ModelAndView mv() { // 모델과 뷰를 같이 다룰 수 있는 객체
		ModelAndView mv = new ModelAndView(); // 이렇게 생성해서 해도 되고 받아서 써도 된다
		mv.addObject("result", "모델앤뷰 객체로 설정"); // 모델은 오브젝트 이름으로 생성
		mv.setViewName("plusresult"); // 뷰 이름을 설정해주면 해당 뷰로 포워드함
		return mv;
	}
	
	@GetMapping("/respentity")
	public ResponseEntity<String> entity() {
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "text/plain; charset=utf-8").body("바디 내용");
		
//		String body = "바디 내용입니다";
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Type", "text/plain; charset=utf-8");
//		ResponseEntity<String> en = new ResponseEntity<>(body, headers, HttpStatus.OK); // 바디내용, 응답코드, 헤더
//		return en;
	}
	
	@GetMapping("/red")
	public String redirect() {
		return "redirect:/";
	}
}
