package kr.co.greenart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.greenart.config.RootConfig;
import kr.co.greenart.model.car.Car;
import kr.co.greenart.model.car.CarService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
// 스프링 4버전 이하 옛날버전엔 @Transactionalconfiguration(defaltRollback = true)로 롤백하는게 있었음
public class CarServiceTest {
	@Autowired
	private CarService service;
	
	@Test(expected = DataAccessException.class) // 예외 이름을 적으면 그 예외가 발생했을 시 테스트 통과
	public void bulkInsert() {
		List<Car> list = Arrays.asList(new Car(0, "AAA", 100)
				, new Car(0, "BBB", 100)
				, new Car(0, "AAA", 100)
				, new Car(0, "CCC", 100));
		
		int[] result = service.bulkInsert(list);
		assertNull(result);
	}
	// 스프링에서 트랜잭션 관리를 어떻게 하느냐
	// 명시적으로 JdbcTemplate처럼 문제가 생기면 롤백해라 하고 명시적으로 만들수도 있고
	// ...
	// 객체끼리의 관심사를 가로질러서 공유하는 문제가 생기는데 이런걸 쉽게 관리할 수 있게끔하는 기능을 제공해줌
	
	@Test
	@Rollback(value = true) // 삭제 등록했다가 삭제되면 안되니까 무조건 롤백해야함
	public void delete() {
		int result = service.delete(1);
		
		assertEquals(1, result);
	}
}
