package kr.co.greenart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flash")
public class FlashAttributeController {
	@GetMapping("/1")
	public String foward(Model model) {
		model.addAttribute("fowardtest", "포워드 테스트");
		
		return "flashview";
	}
	
	@GetMapping("/2")
	public String view() {
		return "flashview";
	}
	
	@GetMapping("/3")
	public String redirect(Model model) {
		model.addAttribute("redirecttest", "리다이렉트 테스트");
		
		return "redirect:2"; // 스프링에서 리다이렉트하는데 모델이 있네? 쓰려고 한건가? 하고 주소에 알아서 파라미터를 집어넣어준다
		// 그렇기 때문에 쓰려면 파라미터 객체에서 꺼내써야한다
		// 근데 이렇게 쓰면 주소에 내가 심은 값이 다 보인다
	}
}