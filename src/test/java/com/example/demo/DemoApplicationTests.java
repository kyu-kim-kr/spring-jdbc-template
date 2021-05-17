package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	@DisplayName("연결 확인")
	void contextLoads() {
		assertThat(applicationContext).isNotNull();
	}

	@Test
	@DisplayName("쿼리 안에 직접 데이터를 적어서 insert 확인")
	void insert() {
		String query = "INSERT INTO user Values(null, 'kyu', 'kim')";
		int updated = this.jdbcTemplate.update(query);
		assertThat(updated).isEqualTo(1);
	}

	@Test
	@DisplayName("쿼리에 데이터를 주입하고 insert 확인")
	void insertWithPreparedStatement() {
		String query = "INSERT INTO user Values(?, ?, ?)";
		this.jdbcTemplate.update(query, null, "kyu", "kim");
	}
}
