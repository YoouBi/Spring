package kr.co.greenart.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class UserRepositoryMySQL implements UserRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private UserRowMapper mapper = new UserRowMapper();
	// 밖에서도 필요하다 싶으면 필드로 꺼내놓고 초기화를 해준다
	
	private class UserRowMapper implements RowMapper<User> {
	// 클래스 안에 작성한 private한 클래스는 이 UserRepositoryMyAQL 내부 안에서만 사용 가능
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			
			return new User(id, name, age); // 이렇게 해두면 한줄만 있지만 알아서 여러줄을 맵핑해준다
		}
	}
	
	@Override
	public int add(User user) {
		return jdbcTemplate.update("INSERT INTO users (name, age) VALUES (?, ?)", user.getName(), user.getAge());
	}

	@Override
	public List<User> list() {
		return jdbcTemplate.query("SELECT * FROM users", mapper); // 익명 클래스 구현도 가능!
		// 우측에는 rowMapper라는 객체가 필요한데
		// resultset에 하나하나 맞는 객체를 던져주는 작업을 해주는 객체
	}
}