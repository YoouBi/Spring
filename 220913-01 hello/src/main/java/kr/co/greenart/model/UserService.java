package kr.co.greenart.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	// 서비스에서 레포지토리에 있는 유저 목록을 가져오고싶으면
	@Autowired
	private UserRepository repo;
	
	public List<User> list() {
		logger.info("-- 유저 목록 불러오기 --");
		return repo.list();
	}
	
	// 인터페이스를 달라고 했으면 구현체를 찾아서 넣어준다
	public int add(User user) {
		logger.info("-- 유저 추가하기 --");
		return repo.add(user);
	}
}
