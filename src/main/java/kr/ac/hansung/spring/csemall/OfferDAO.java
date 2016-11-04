package kr.ac.hansung.spring.csemall;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

// compiler가 component를 자동으로 bean 등록
@Component("offerDAO")
public class OfferDAO {
	
	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "Select count(*) from offers";
		
		// sql문을 수행 후 하나의 객체(integer 타입)를 return
		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);
	}
}
