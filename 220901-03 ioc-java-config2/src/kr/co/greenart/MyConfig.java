package kr.co.greenart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// Arraylist같은 클래스는 내가 만든게 아니라 이미 만들어져있는 클래스인데
// 그런 클래스에 어떻게 component를 어노테이션하냐
// 그래서 아예 component-scan.xml을 지우고
@Configuration // 설정을 가지고 있는 컴포넌트를 Configuration라고 하는데 설정을 똑같이 해줄 수 있다
@ComponentScan(value = "kr.co.greenart")
public class MyConfig {
	@Bean
	public List<Integer> myList() { // 타입을 반환타입쪽에 쓰고 부르고싶은 이름을 메소드 이름으로 배치한다
		return new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)); // 등록하고자하는 객체를 메소드 안에서 반환해주면 된다
	}
	
	@Bean
	public Set<Integer> mySet() {
		return new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
	}
}
