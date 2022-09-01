package kr.co.greenart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Service // 결국엔 다 똑같은 컴포넌트인데 Service라고 쓰는건 뭔가 로직이 있다는 표시
@Repository // 저장소도 똑같은 컴포넌트
public class MyService {
	@Autowired // 이때 구현체가 두개가 있으니까 둘 중에 하나 선택할 수 있게끔 Qualifier로 이름을 알려줌
	@Qualifier(value="mylist") // 어노테이션에 value=라는 친구는 다 없애줘도 된다
	private MyDataRepository repo;
	
	public Iterable<Integer> numberService() {
		return repo.getMyNumbers();
	}
}
