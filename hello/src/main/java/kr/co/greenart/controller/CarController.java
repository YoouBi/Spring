package kr.co.greenart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.greenart.model.car.Car;
import kr.co.greenart.model.car.CarService;

@Controller
@RequestMapping("/car")
@ResponseBody // 응답하는 모든 내용이 @ResponseBody라면 이 어노테이션을 컨트롤러 위에 위치시킬 수 있음
public class CarController {
	private static Logger logger = LoggerFactory.getLogger(CarController.class);
	@Autowired
	private CarService service;
	
	@GetMapping
//	public ResponseEntity<String> view() {
//		return ResponseEntity<"">;
	public List<Car> view() { // 원래는 public @ResponseBody List<Car> view() { 였음
//	public @ResponseBody String view() {
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.writeValue(); // 이 방식을 스프링은 자동으로 해준다
//		return service.list().toString(); // 다만 Jackson Databind만 가능!
		return service.list();
	}
	
	@GetMapping("/{id}")
	public Car carById(@PathVariable int id) {
		return service.getById(id);
	}
	
	// 요청을 보내야되는 양식을 제이슨으로 지정
	@PostMapping
	public ResponseEntity<String> add(@RequestBody Car car) {
		logger.info(car.toString());
		service.add(car);
		
		return ResponseEntity.ok("{ \"result\" : \"ok\" }");
	} // 기능은 제공할 수 있는데 주소와 요청방식에 의해서(소통방법 약속은 해야함)...
	
	// 보통은 post나 put을 씀
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Car car) {
		service.update(car);
		
		return ResponseEntity.ok("{ \"result\" : \"ok\" }");
	}
	
	@DeleteMapping("/{id}") // 보통 이런 api는 자신과 같은 개발자 직군에게 쓰라고 만들어놓는 것 -> 내가 아닌 사용자니 메뉴얼을 만들어놓는 편
	public ResponseEntity<String> delete(@PathVariable int id) {
		service.delete(id);
		
		return ResponseEntity.ok("{ \"result\" : \"ok\" }");
	}
}