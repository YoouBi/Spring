package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mapping")
public class MappingController {
	// 여기에서는 왜 한글이 안될까...
	// 응답으로 바디를 보내줬는데 뭘 보내줄건지 안 알려줌
	// 그래서 톰캣에서 기본값으로 설정된게 UTF-8이 아니기 때문에...
	// 응답 헤더(Response Header)를 바꿔줘야함 즉 리스폰스 객체가 필요
	@GetMapping(value="/??.two", produces="text/plain; charset=utf-8") // json에만 해주면 된다구...?
	public @ResponseBody String two() {
		return "두글자 매핑";
	}
	
	@GetMapping("/*.do")
	public @ResponseBody String doURI() {
		return "do로 끝나는 매핑";
	}
	
	// @GetMapping(value="/ppp", params="!com") 이런 부정 표현도 가능해서 입력 값이 있을때와 없을 때로 핸들링을 줄 수 있다!
	@GetMapping(value="/ppp", params="com") // 헤더도 설정이 가능한데 헤더는 무조건 이름=값이 쌍으로 있어야한다
	public @ResponseBody String ppp(@RequestParam(defaultValue="default") String com) { // 값이 없으면 defaultValue로 기본으로 넣어줄 값을 넣어줄 수 있다
//		return "ppp";
		return com;
	}
	// 그냥 ppp를 쓰면 400으로 잘못된 요청이라는 오류페이지가 뜬다
	// 옆에 params="com"을 써줬는데 이는 com 파람이 꼭 있어야한다는 뜻으로 ppp?com=로 값이 없어도 com파라미터만 써준다면 이동할 수 있지만
	// 만약 "com=val"처럼(맵핑 주소에도 정규식이 된다!) 값까지 지정해준다면 val이라는 값을 적지 않으면 이동할 수 없다
}