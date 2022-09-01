package kr.co.greenart;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("myset")
//@Primary 이렇게 우선 순위를 주거나 컴포넌트에 이름을 줌
public class MySetRepository implements MyDataRepository {

	@Override
	public Iterable<Integer> getMyNumbers() {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		return set;
	}
}
