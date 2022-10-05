package kr.co.greenart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	@GetMapping("/")
//	public @ResponseBody String index() {
	public String index() {
//		return "index String";
		return "welcome";
	}
}