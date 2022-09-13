package kr.co.greenart.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:kr/co/greenart/config/mysql.properties")
//@ComponentScan("kr.co.greenart.model.car")
@EnableTransactionManagement // 트랜잭션 관리를 할 객체를 사용하겠다
// 이 트랜잭션을 관리할 수 있는 관리자를 빈으로 등록시켜주면 됨
public class RootConfig {
	@Value("${jdbc.drivername}")
	private String drivername;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
//	@Autowired
//	private DataSource ds;
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(drivername);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		
		return ds;
	}
	
	@Bean
	@Autowired // 또는 이런 Bean이 필요한 데이터를 달라고하면 그 객체를 넣어서 쓸 수 있다
	public JdbcTemplate jdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	@Bean
	@Autowired
	public PlatformTransactionManager txManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
		// 이때도 마찬가지로 dataSource에 대한 의존성이 필요하니 @Autowired를 붙이고 파라미터로 받아온다
	}
	
	@Bean
	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource ds) {
		return new NamedParameterJdbcTemplate(ds);
	}
}