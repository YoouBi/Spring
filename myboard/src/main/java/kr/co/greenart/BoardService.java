package kr.co.greenart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	@Autowired
	private BoardMapper dao; // 빈으로 올라온걸 알아서 추가해줌
	
	public List<Article> getAll() {
		return dao.getAll();
	}

	public int write(Article a) {
		return dao.write(a);
	}
}
