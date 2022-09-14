package kr.co.greenart.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository // 서비스를 제공해주기 위해서 이 친구를 컴포넌트로 사용할거니까
public class UserRepositoryListImpl implements UserRepository {
	private List<User> list = new ArrayList<>();
	
	@Override
	public int add(User user) {
		return list.add(user) ? 1 : 0;
	}

	@Override
	public List<User> list() {
		return list;
	}
}