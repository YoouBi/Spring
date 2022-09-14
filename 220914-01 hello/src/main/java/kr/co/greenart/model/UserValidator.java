package kr.co.greenart.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
// 유효값을 가지고있는 객체(유효성 검사해주는 인터페이스 붙여줌)
public class UserValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz); //유저 타입만 검사하려고 설정한 것
	}

	@Override
	public void validate(Object target, Errors errors) { // 여기서 유효성 체크를 하면 됨
		// target이라고 넘어오는 친구가 유효성 체크를 할 객체이고
		// errors에 어떤 필드에 어떤 잘못이 있는지(null이나 공백이라던지, 길이값 체크라던지) 하나하나 설정해줌
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "이름을 입력하세요");
		// rejectIfEmptyOrWhitespace는 공백이거나 비어있으면 스태틱한 메소드로
		// errors와 전달받은 필드이름, 부여할 코드 이름과 내용을 알아서 집어넣어준다
		// validate는 문자열에 대해서는 공백을 알아서 체크할 수 있도록 만들어져있다
		User user = (User) target; // 나머지는 우리가 체크할 수 있도록 다운케스팅
		if(user.getName().length() > 5) {
			errors.rejectValue("name", "name.toolong", "이름이 너무 깁니다");
		}
		if (user.getAge() > 200) {
			errors.rejectValue("age", "age.tooold", "나이 범위를 초과했습니다.");
		}
	}
}
