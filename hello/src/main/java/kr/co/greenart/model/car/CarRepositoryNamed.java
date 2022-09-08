package kr.co.greenart.model.car;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class CarRepositoryNamed implements CarRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@Override
	public List<Car> getAll() {
		return jdbc.query("SELECT * FROM cars", new BeanPropertyRowMapper<Car>(Car.class));
		// 우리가 다루는 컬럼 이름이랑 객체 이름과 필드 이름이 같고 게터세터가 존재한다면 알아서 호출해서 맵핑해줌
	}

	@Override
	public Car getById(int id) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id", id);
		return jdbc.queryForObject("SELECT * FROM cars WHERE id=:id"
				, map
				, new BeanPropertyRowMapper<Car>(Car.class));
		// 두번째 paramMap에 첫번째 :id로 적어준 이름값을 가진 맵을 넘겨줌
	}

	@Override
	public int add(Car car) {
		return jdbc.update("INSERT INTO cars (model, price) VALUES (:model, :price)"
				, new BeanPropertySqlParameterSource(car));
	}

	@Override
	public int[] batchInsert(List<Car> list) {
		return jdbc.batchUpdate("INSERT INTO cars (model, price) VALUES (:model, :price)"
				, SqlParameterSourceUtils.createBatch(list));
	}

	@Override
	public int update(Car car) {
		return jdbc.update("UPDATE cars SET model=:model, price=:price WHERE id=:id"
				, new BeanPropertySqlParameterSource(car));
	}

	@Override
	public int delete(int id) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id", id);
		return jdbc.update("DELETE FROM cars WHERE id=:id", map);
	}
	
}
