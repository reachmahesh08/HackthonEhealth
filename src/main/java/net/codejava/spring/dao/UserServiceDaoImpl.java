package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import net.codejava.spring.model.BmiDetail;
import net.codejava.spring.model.User;
import net.codejava.spring.model.UserLogin;




@Repository("userServiceDao")
public class UserServiceDaoImpl implements UserServiceDao {

	private JdbcTemplate jdbcTemplate=new JdbcTemplate(getDataSource());
	/*public UserServiceDaoImpl(DataSource dataSource) {
	        jdbcTemplate = new JdbcTemplate(dataSource);
	    }*/
	@Override
	public boolean getUser(UserLogin user) {
		System.out.print("User name in dao"+user.getUserName());
	String sql="SELECT * FROM USER WHERE USERNAME='"+user.getUserName()+"'" +" AND PASSWORD='"+user.getPwd()+"'";
		List<UserLogin> list = jdbcTemplate.query(sql,
				new RowMapper<UserLogin>() {

					@Override
					public UserLogin mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						System.out.print("User Name in Mapper"+rs.getString("USERNAME"));
						UserLogin user = new UserLogin();
						user.setPwd(rs.getString("PASSWORD"));
						user.setUserName(rs.getString("USERNAME"));

						return user;

					}

				});
		if(list!=null&&list.size()>0){
			return true;
		}else{
			return false;
		}
	
		
	}
	
	
	public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/eahealth");
        dataSource.setUsername("root");
        dataSource.setPassword("my_sql_amit");
         
        return dataSource;
	
}

private int selectMaxNoFromTable(String sql){
	int id=0;
	List<Integer> listId=jdbcTemplate.query(sql, new RowMapper<Integer>(){

		@Override
		public Integer mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			if(rs.getString(1)!=null){
				return Integer.parseInt(rs.getString(1));
			}else{
			
			return 1;
		}
		}
		
	});
	if(listId!=null&&listId.size()>0){
		id=listId.get(0);
	}else id=1;
	return id;
}
	@Override
	public int insertRegistrationDetail(User user) {
		
		String selectsql_user="SELECT MAX(ID)+1 FROM USER";
		String selectsql_bmi="select (max(id)+1) from bmi_chart";
		int userid=selectMaxNoFromTable(selectsql_user);
		int bmiId=selectMaxNoFromTable(selectsql_bmi);
		String sql="INSERT INTO USER "
				+ "(`ID`, `USERNAME`, `PASSWORD`, `EMAIL`, `GENDER`, `AGE`, `WEIGHT`, `HEIGHT`) "
				+ "VALUES ("+userid+",'"+user.getUsername()+"', '"+user.getPassword()+"', '"+user.getEmail()
				+"', '"+user.getGender()+"', "+user.getAge()+","+user.getWeight()+" ,'"+user.getHeight()+"')";
		
		int i=jdbcTemplate.update(sql);
		
		BmiDetail bmiDetail=user.getBmiDetail();
		String sql2="INSERT INTO BMI_CHART "
				+ "(`ID`, `USER_ID`, `BMI`, `LEVEL`, `CATEGORY`, `PERCENTILE`)"
				+ " VALUES ("+bmiId+","+userid+", "+bmiDetail.getBmi()+", "+bmiDetail.getLevel()+", '"+bmiDetail.getCategory()+"', 0)";
		int i1=jdbcTemplate.update(sql2);
		
		return 0;
		// TODO Auto-generated method stub
		
	}


	@Override
	public User fetchBMIDetail(String name) {
		String sql="select u.username,bmi.bmi,bmi.category from "
				+ "user u,bmi_chart bmi where u.id=bmi.user_id and u.username='"+name+"'";
		List<User> list = jdbcTemplate.query(sql,
				new RowMapper<User>() {

					@Override
					public User mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						System.out.print("User Name in Mapper"+rs.getString("USERNAME"));
						User user = new User();
						BmiDetail bmi=new BmiDetail();
						user.setUsername(rs.getString("USERNAME"));
						bmi.setBmi(rs.getString("bmi"));
						bmi.setCategory("category");
						user.setBmiDetail(bmi);

						return user;

					}

				});
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
		
		
	}
	

}
