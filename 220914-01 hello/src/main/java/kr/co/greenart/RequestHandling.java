package kr.co.greenart;



import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestHandling {
	private final static Logger logger = LoggerFactory.getLogger(RequestHandling.class);
	
	@RequestMapping(value = "/req", method = RequestMethod.GET)
//	public String req(HttpServletRequest request) {
//		String param = request.getParameter("param");
//		String param2 = request.getParameter("param2");
//	
//		logger.info(param);
	public String req(@RequestParam int param, @RequestParam int param2, Model model) {	
		logger.info(String.valueOf(param + param2));
		model.addAttribute("result", param + param2);
		// Model은 필요한 영역을 자기가 알아서 관리해서 우리가 세션에 넣어라, 리퀘스트에 넣어라를 요청할 수 없다
		
		return "plusresult"; // 뷰 이름
	}
}