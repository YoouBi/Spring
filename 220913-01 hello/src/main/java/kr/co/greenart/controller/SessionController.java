package kr.co.greenart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value = "/session", produces = "text/plain; charset=utf-8")
@ResponseBody
@SessionAttributes("modelname") // 해당 이름의 어트리뷰트 값들은 세션값으로 관리가 된다
// 관리는 해주지만 정직하게 세션 안으로 넣어주는게 아니라 이 안에서만 세션값으로 관리해주기 때문에
// 다른 컨트롤러에서 이 값을 쓰고자하면 없는 것처럼 보인다
// (스코프가 특이:일반적인 세션 범위가 아니고 리퀘스트처럼 값을 받는 것도 아니고 req<이 사이<session)
// 따라서 하나의 컨트롤러에서 세션값처럼 쓰고싶다면 @SessionAttributes를,
// 웹 전역의 세션에서 쓰고자한다면 일반적인 세션 스코프로 사용해야한다
public class SessionController {
	@GetMapping("/add")
	public String addSessionValue(HttpSession session) {
		session.setAttribute("myname", "myvalue");
		return "세션에 값 설정";
	}
	
	@GetMapping("/check")
	public String getSessionValue(HttpSession session) {		
		return (String) session.getAttribute("myname");
	}
	
	@GetMapping("/model")
	public String addModelValue(Model model) {
		model.addAttribute("modelname", "modelvalue");
		return "모델에 값 설정";
	}
	
	@GetMapping("/modelcheck") // 세션을 만들지 않아서 안되는 것이니까 add->model->modelcheck로 가야함
	public String getModelValue(Model model) {
		return (String) model.getAttribute("modelname");
	}
	
	@GetMapping("/status")
	public String complete(SessionStatus status) {
		status.setComplete();
		return "세션 어트리뷰트 삭제되었음";
	}
}
