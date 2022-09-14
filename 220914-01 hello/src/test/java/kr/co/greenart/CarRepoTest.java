package kr.co.greenart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.greenart.model.car.Car;
import kr.co.greenart.model.car.CarRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { kr.co.greenart.config.RootConfig.class })
public class CarRepoTest {	
	@Autowired
	private CarRepository repository; // 이 객체를 테스트하려면 객체가 있어야하는데 = new CarRepository로 해도 되지만
	// 빈을 등록하고 그게 잘 작동되는지 테스트 하려는거니까
	// Root Config에 빈을 메소드로써 등록해도 되지만 그럴 필요는 없고
	// CarRepositpry에 @Repository로 빈을 등록해주고
	// Root Config에 @ComponentScan("kr.co.greenart.model.car")을 해주면...
	// 혹은 Root Config에 @ComponentScan("kr.co.greenart.model.car")을 쓰지 않고 위에 kr.co.greenart.model.car...?.class...
	// 왜 안썼지 뭐때문에 안쓴댔지...
	
	@Test
	public void initTest() {
		assertNotNull(repository);
	}
	
	// 자료가 없으니 만들어놓고 시작하자 -> 테스트 환경 만들기
	@BeforeClass // 해당 메소드가 다른 테스트 메소드들이 실행되기 전에 먼저 한번 실행되는 어노테이션으로 static 메소드로 만들어야한다
	public static void addTestData() {
//		Random r = new Random();
//		repository.add(new Car(0, "테스트 자료" + r.nextInt(10000), r.nextInt(10000)));
//		repository.add(new Car(0, "테스트 자료" + r.nextInt(10000), r.nextInt(10000)));
//		repository.add(new Car(0, "테스트 자료" + r.nextInt(10000), r.nextInt(10000)));
	}
	
	@Test
	public void create() {
		Random r = new Random();
		Car car = new Car();
		car.setModel("새 모델" + r.nextInt(10000));
		car.setPrice(1000);
	
		int result = repository.add(car);
		assertEquals(1, result);
	}
	
	@Test
	public void read() {
		List<Car> list = repository.getAll();
		
		assertNotNull(list);
	}
	
	@Test
	public void update() {
		int result = repository.update(new Car(1, "변경", 300));
		
		assertEquals(1, result);
	}
}
