package kr.co.greenart.model;

import javax.validation.constraints.Max; // 패키지에 우클릭하고 open type Heirarchy하면 해당 패키지의 목록들이 뜬다
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class User {
	private int id;
	@NotBlank(message = "이름을 입력해주세요.") // 값이 없거나 공백으로만 되어있으면 에러 유효성 메세지를 심어줌
	@Size(min = 1, max = 4, message = "이름은 1~4자 사이여야합니다.")
	private String name;
	@Positive(message = "양수를 입력해주세요.")
	@Max(value = 100, message = "최댓값(100)을 초과했습니다.")
	private int age;
	// int형이라 아무것도 안쓰면 null 값을 가질 수 없기 때문에 ""로 인식한다
	// 따라서 null 허용하기 위해서 Integer로 쓰고 맵핑을 자동적으로 하고 있으니 수동화 시키거나 예외를 처리할 수 있게끔 만들어줘야한다
	
	public User() {}
	
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public User(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
