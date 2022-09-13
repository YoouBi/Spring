package kr.co.greenart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.greenart.config.RootConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
public class JdbcTemplateTest {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void test() {
		int result = jdbcTemplate.queryForObject("SELECT 1", int.class);
		
		assertEquals(1, result);
	}
	
	@Test
	public void update() {
		int result = jdbcTemplate.update("UPDATE users SET name=?, age=? WHERE id=?"
				, "새이름"
				, 22
				, 1);
				
		assertNotEquals(0, result);
	}
	
//	@Test
//	public void delete() {
//		int result = jdbcTemplate.update("DELETE FROM users WHERE id=?", 2);
//		
//		assertEquals(1, result);
//	}
	
	@Test
	public void queryForList() {
		List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM users");
		// db의 한 행을 표현하자면 맵 한개로 표현이 가능하니까
		// 여러행이 있다면 맵 여러개로 테이블 표현이 가능하니
		// 맵핑이 필요없는 간단한 셀렉문은 이런 queryForList로 반환이 가능
		
		assertEquals(2, list.size());
		assertEquals("새이름", list.get(0).get("name"));
	}
}
