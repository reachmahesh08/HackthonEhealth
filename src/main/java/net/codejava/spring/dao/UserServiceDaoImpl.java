package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import net.codejava.spring.model.BmiDetail;
import net.codejava.spring.model.Nutrition;
import net.codejava.spring.model.User;
import net.codejava.spring.model.UserLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("userServiceDao")
public class UserServiceDaoImpl implements UserServiceDao {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean getUser(UserLogin user) {
		String sql = "SELECT * FROM USER WHERE USERNAME='" + user.getUserName()
				+ "'" + " AND PASSWORD='" + user.getPwd() + "'";
		List<UserLogin> list = jdbcTemplate.query(sql,
				new RowMapper<UserLogin>() {

					@Override
					public UserLogin mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						UserLogin user = new UserLogin();
						user.setPwd(rs.getString("PASSWORD"));
						user.setUserName(rs.getString("USERNAME"));

						return user;

					}

				});
		if (list != null && list.size() > 0) {
			return true;
		} else {
			return false;
		}

	}

	private int selectMaxNoFromTable(String sql) {
		int id = 0;
		List<Integer> listId = jdbcTemplate.query(sql,
				new RowMapper<Integer>() {

					@Override
					public Integer mapRow(ResultSet rs, int arg1)
							throws SQLException {
						// TODO Auto-generated method stub
						if (rs.getString(1) != null) {
							return Integer.parseInt(rs.getString(1));
						} else {

							return 1;
						}
					}

				});
		if (listId != null && listId.size() > 0) {
			id = listId.get(0);
		} else
			id = 1;
		return id;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public int insertRegistrationDetail(User user) throws Exception {
		try {
			String selectsql_user = "SELECT MAX(ID)+1 FROM USER";
			String selectsql_bmi = "select (max(id)+1) from bmi_chart";
			int userid = selectMaxNoFromTable(selectsql_user);
			int bmiId = selectMaxNoFromTable(selectsql_bmi);
			String sql = "INSERT INTO USER "
					+ "(`ID`, `USERNAME`, `PASSWORD`, `EMAIL`, `GENDER`, `AGE`, `WEIGHT`, `HEIGHT`) "
					+ "VALUES (" + userid + ",'" + user.getUsername() + "', '"
					+ user.getPassword() + "', '" + user.getEmail() + "', '"
					+ user.getGender() + "', " + user.getAge() + ","
					+ user.getWeight() + " ,'" + user.getHeight() + "')";

			int i = jdbcTemplate.update(sql);

			BmiDetail bmiDetail = user.getBmiDetail();
			String sql2 = "INSERT INTO BMI_CHART "
					+ "(`ID`, `USER_ID`, `BMI`, `LEVEL`, `CATEGORY`, `PERCENTILE`,BMR)"
					+ " VALUES (" + bmiId + "," + userid + ", "
					+ bmiDetail.getBmi() + ", " + bmiDetail.getLevel() + ", '"
					+ bmiDetail.getCategory() + "', 0,'" + bmiDetail.getBmr()
					+ "')";
			int i1 = jdbcTemplate.update(sql2);
			return 0;
		} catch (Exception e) {
			throw new Exception("Error while inserting " + e);
		}

		// TODO Auto-generated method stub

	}

	@Override
	public User fetchBMIDetail(String name) {
		String sql = "select u.username,bmi.bmi,bmi.category,u.gender,u.age,u.weight,u.height,bmi.bmr from "
				+ "user u,bmi_chart bmi where u.id=bmi.user_id and u.username='"
				+ name + "'";
		List<User> list = jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				BmiDetail bmi = new BmiDetail();
				user.setUsername(rs.getString("USERNAME"));
				user.setAge(rs.getString("AGE"));
				user.setWeight(rs.getString("WEIGHT"));
				user.setHeight(rs.getString("HEIGHT"));
				user.setGender(rs.getString("GENDER"));
				bmi.setBmi(rs.getString("bmi"));
				bmi.setCategory("category");
				bmi.setBmr(rs.getString("bmr"));
				user.setBmiDetail(bmi);

				return user;

			}

		});
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public Nutrition fetchNutionChart(String foodType) {
		try {
			String sql = "select CALORIES,fiber from nutrition where FOOD_TYPE='"
					+ foodType + "'";

			Nutrition nutrition = null;

			List<Nutrition> nutritionList = jdbcTemplate.query(sql,
					new RowMapper<Nutrition>() {

						@Override
						public Nutrition mapRow(ResultSet rs, int arg1)
								throws SQLException {
							Nutrition nutrition = new Nutrition();
							nutrition.setCalories(rs.getString(1));
							nutrition.setFiber(rs.getString(2));
							return nutrition;

						}

					});
			if (nutritionList != null && nutritionList.size() > 0) {
				nutrition = nutritionList.get(0);
			}
			return nutrition;

		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<String> fetchNutritionBreakfastMenu(String foodType) {
		String sql = "SELECT FOOD_TYPE FROM NUTRITION WHERE FOOD_CLASSIFICATION='"
				+ foodType + "'";
		return jdbcTemplate.query(sql, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int arg1) throws SQLException {
				// TODO Auto-generated method stub

				return rs.getString(1);

			}

		});
	}

}
