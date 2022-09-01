package kr.co.greenart;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.filter.CharacterEncodingFilter;

// "/print" GET 요청 -> text 입력 가능 (view)form.jsp로 foward
// form.jsp submit시 "/print" POST 요청 -> 입력한 text 그대로를 볼 수 있는 (view)print.jsp로 forward

@Controller
public class PrintController {
	private final static Logger logger = LoggerFactory.getLogger(RequestHandling.class);
	
	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public String print() {
		return "form";
	}
	
	@RequestMapping(value = "/print", method = RequestMethod.POST)
	public String print(@RequestParam String text, Model model) {
		logger.info(text);
		model.addAttribute("text", text);
		
		return "print";
	}
}
