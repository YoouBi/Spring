package kr.co.greenart.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.greenart.model.User;
import kr.co.greenart.model.UserService;
import kr.co.greenart.model.UserValidator;

@Controller
public class UserController {
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
//	@Autowired
//	private UserValidator validator;
	
	@Autowired
	private UserService service;
	
	@ModelAttribute("user")
	public User user() {
		return new User("기본값", 1);
	}
	
	@GetMapping("/user")
	public String userForm(@ModelAttribute("user") User user) {
//	public String userForm(Model model) {
//		model.addAttribute("user", new User("기본값", 1));
		return "userForm";
	}
	
	@PostMapping("/user")
//	public String submit(@RequestParam String name, @RequestParam int age) {
//		User user = new User(name, age);
	
//	public String submit(User user) { // 여러 파라미터를 적어놓지 않더라도 표현할 수 있는 클래스만 잘 적어놓으면 바인딩해서 쓸 수 있음!
		// 입력에 따른 유효값은 전혀 신경쓰지 않고 필드에 집어넣기만 한 것
		// 따라서 유효하다는 정의는 우리가 만들어줘야한다!
//	public String submit(@ModelAttribute("user") User user, BindingResult errors) {
	public String submit(@ModelAttribute("user") @Valid User user, BindingResult errors) {
		logger.info("입력 정보: " + user.toString());
		
		// 유효성 검사를 위해 얘를 날리고 라이브러리 의존성 하나를 추가함
//		validator.validate(user, errors);
		
		if (errors.hasErrors()) {
			return "userForm";
		}
		service.add(user);
		
//		return "redirect:/";
		return "redirect:/user/list";
	}
	
	@GetMapping("/user/list")
	public String list(Model model) {
		model.addAttribute("list", service.list());
		return "userlist";
	}
}