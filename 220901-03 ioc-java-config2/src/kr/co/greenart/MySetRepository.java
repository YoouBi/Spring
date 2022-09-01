package kr.co.greenart;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("myset")
//@Primary 이렇게 우선 순위를 주거나 컴포넌트에 이름을 줌
public class MySetRepository implements MyDataRepository {
	@Autowired
	private Set<Integer> set;
	
	@Override
	public Iterable<Integer> getMyNumbers() {
		return set;
	}
}
