package kr.co.greenart.model.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarService {
	@Autowired
	private CarRepository repo;
	
	// 자동차 목록을 전달받아 추가
	@Transactional //트랜잭션이 필요하다고 적어줌
	// 내부에서 오류가 생기면 런타임 예외를 던져주고, 롤백이 될 것이다
	public int[] bulkInsert(List<Car> list) {
//		int[] results = new int[list.size()];
//		for (int i = 0; i < list.size(); i++) {
//			results[i] = repo.add(list.get(i));
//		}
		int[] results = repo.batchInsert(list);
		return results;
	}
	
	@Transactional
	public int delete(int id) {
		return repo.delete(id);
	}
}
