package kr.co.greenart;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.filter.CharacterEncodingFilter;

// "/print" GET 요청 -> text 입력 가능 (view)form.jsp로 foward
// form.jsp submit시 "/print" POST 요청 -> 입력한 text 그대로를 볼 수 있는 (view)print.jsp로 forward

@Controller
@RequestMapping(value = "/print")
public class PrintController {
//	private final static Logger logger = LoggerFactory.getLogger(RequestHandling.class);
	
	//@RequestMapping(value = "/print", method = RequestMethod.GET)
	@GetMapping // 버전을 올리면 새 어노테이션을 쓸 수 있는데 이 GetMapping은 똑같지만 좀 더 줄여쓸 수 있다
//	public String print() {
	public String printForm() {
		return "form";
	}
	
	//@RequestMapping(value = "/print", method = RequestMethod.POST)
	@PostMapping
//	public String print(@RequestParam String text, Model model) {
	public String printView(HttpServletRequest req, @RequestParam String text, Model model) {
//		logger.info(text);
//		model.addAttribute("text", text);
//		
//		return "print";
		
//		// 이렇게하면  서블릿보다 먼저 동작하는 필터를 사용해줘야한다
//		try {
//			req.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
		model.addAttribute("text", text);
		return "print";
	}
	
	@GetMapping("/sub")
	public @ResponseBody String sub() { // print의 하위 경로 /sub를 요청하는데
		return "/print/sub"; //위에 @RequestMapping(value = "/print")로 해놨기 때문에 /print/sub로 가는 것이다
	} // 만약  @RequestMapping이 없다면 /print 없이  그냥 /sub로 경로가 갔을 것
	// 그냥 http://localhost:8080/greenart/sub 을 치면 404가 뜨지만
	// http://localhost:8080/greenart/print/sub을 치면 /print/sub가 뜰 것
	
	//@ResponseBody는 뷰가 필요 없을 때(api 만들어서 값만 주고받을 때) 많이 쓴다
}
