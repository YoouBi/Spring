package kr.co.greenart.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice(annotations = ) // 해당 어노테이션이 붙어있는 컨트롤러에만 특정하여
//@ControllerAdvice(assignableTypes = class )
//@ControllerAdvice(basePackages =  )
@ControllerAdvice // 비어있으면 전역적으로 모든 컨트롤러에 사용할 수 있는 컨트롤러들을 보조해주는 역할을 함
public class ErrorHandler {
	@ExceptionHandler(value = NullPointerException.class) // 어느 예외를 처리할것인지 value 값으로 명시 가능
	public String nullExcep(Model model, NullPointerException ex) {
		model.addAttribute("error", "서버에서 오류가 발생했습니다. 죄송합니다." + ex.getMessage());
		return "errorpage";
	}
}