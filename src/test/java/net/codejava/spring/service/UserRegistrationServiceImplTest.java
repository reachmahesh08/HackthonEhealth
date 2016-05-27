package net.codejava.spring.service;

import java.util.ArrayList;
import java.util.List;

import net.codejava.spring.dao.UserServiceDao;
import net.codejava.spring.model.BmiDetail;
import net.codejava.spring.model.Nutrition;
import net.codejava.spring.model.User;

import org.easymock.EasyMock;
import org.easymock.Mock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRegistrationServiceImplTest {

	@Autowired
	UserRegistrationServiceImpl userRegistrationService;

	@Mock
	UserServiceDao userServiceDao;

	@Before
	public void setUp() throws Exception {
		userServiceDao = EasyMock.createMock(UserServiceDao.class);
		userRegistrationService = new UserRegistrationServiceImpl();
		userRegistrationService.setUserServiceDao(userServiceDao);
	}

	@Test
	public void submitUserTestCatOverWeight() {
		User user = new User();
		user.setHeightft("5");
		user.setHeight("5");
		user.setHeightinch("2");
		user.setWeight("70");
		user.setGender("Male");
		user.setAge("19");
		userRegistrationService.submitUser(user);

	}

	@Test
	public void submitUserTestCatNormal() {
		User user = new User();
		user.setHeightft("5");
		user.setHeight("5");
		user.setHeightinch("2");
		user.setWeight("50");
		user.setAge("19");
		userRegistrationService.submitUser(user);

	}

	@Test
	public void submitUserTestCatObeseBmigt40() {
		User user = new User();
		user.setHeightft("5");
		user.setHeight("5");
		user.setHeightinch("2");
		user.setWeight("150");
		user.setAge("19");
		userRegistrationService.submitUser(user);

	}

	@Test
	public void submitUserTestException() {
		User user = new User();
		user.setHeightft("6");
		user.setHeight("5");
		user.setHeightinch("2");
		user.setWeight("150");
		user.setAge("19");
		userRegistrationService.submitUser(user);

	}
	
	@Test
	public void submitUserTestCat() {
		User user = new User();
		user.setHeightft("6");
		user.setHeight("5");
		user.setHeightinch("2");
		user.setWeight("10");
		user.setAge("19");
		user.setGender("Male");
		userRegistrationService.submitUser(user);

	}

	@Test
	public void verifyUserTest() {
		User user = new User();
		BmiDetail bmi = new BmiDetail();
		user.setUsername("USERNAME");
		user.setAge("AGE");
		user.setWeight("80");
		user.setHeight("1.784");
		user.setGender("MALE");
		bmi.setBmi("bmi");
		bmi.setCategory("category");
		bmi.setBmr("bmr");
		user.setBmiDetail(bmi);
		EasyMock.expect(userServiceDao.fetchBMIDetail("USERNAME")).andReturn(
				user);
		EasyMock.replay(userServiceDao);
		userRegistrationService.verifyUser("USERNAME");

	}

	@Test
	public void verifyUserTestReturnNull() {
		User user = new User();
		BmiDetail bmi = new BmiDetail();
		user.setUsername("USERNAME");
		user.setAge("AGE");
		user.setWeight("80");
		user.setHeight("1.784");
		user.setGender("MALE");
		bmi.setBmi("bmi");
		bmi.setCategory("category");
		bmi.setBmr("bmr");
		user.setBmiDetail(bmi);
		EasyMock.expect(userServiceDao.fetchBMIDetail("USERNAME")).andReturn(
				null);
		EasyMock.replay(userServiceDao);
		userRegistrationService.verifyUser("USERNAME");

	}

	@Test
	public void fetchFoodTypeTest() {
		List<String> NutritionBreakfastMenu = new ArrayList<String>();
		NutritionBreakfastMenu.add("TESTING1");
		NutritionBreakfastMenu.add("TESTING2");
		EasyMock.expect(
				userServiceDao.fetchNutritionBreakfastMenu("VEGETERIAN"))
				.andReturn(NutritionBreakfastMenu);
		EasyMock.replay(userServiceDao);
		userRegistrationService.fetchFoodType("VEGETERIAN");

	}

	@Test
	public void fetchcaloriesTest() {
		Nutrition nutrition = new Nutrition();
		nutrition.setCalories("1");
		nutrition.setFiber("3");
		EasyMock.expect(userServiceDao.fetchNutionChart("VEGETERIAN"))
				.andReturn(nutrition);
		EasyMock.replay(userServiceDao);
		userRegistrationService.fetchcalories("VEGETERIAN");

	}

	@Test
	public void caluculateBMRTest() {
		User user = new User();
		user.setHeightft("6");
		user.setHeight("5");
		user.setHeightinch("2");
		user.setWeight("150");
		user.setAge("19");
		userRegistrationService.caluculateBMR(user);

	}
}
