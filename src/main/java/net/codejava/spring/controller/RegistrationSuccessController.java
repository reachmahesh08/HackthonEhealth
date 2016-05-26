package net.codejava.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.codejava.spring.model.Nutrition;
import net.codejava.spring.model.NutritionDetail;
import net.codejava.spring.model.User;
import net.codejava.spring.service.UserRegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class RegistrationSuccessController {
	private static double totalCal=0;
	private static double totalCalLimit=0;
	@Autowired
	@Qualifier("userRegistrationService")
	UserRegistrationService userRegistrationService;
	
	
	public UserRegistrationService getUserRegistrationService() {
		return userRegistrationService;
	}


	public void setUserRegistrationService(
			UserRegistrationService userRegistrationService) {
		this.userRegistrationService = userRegistrationService;
	}


	@RequestMapping(method = RequestMethod.GET,value = "/RegistrationSuccess")
	public void getRegistrationSuccess(Map<String, Object> model,
			HttpSession session) throws Exception {
		NutritionDetail nutrition = new NutritionDetail();

		try {
			populateModel(model);
			populateUser(nutrition, session);
			Nutrition nut = new Nutrition();
			nut.setId(0);
			List<Nutrition> breaskfastList = new ArrayList<Nutrition>();
			breaskfastList.add(nut);
			nutrition.setBreaskfastList(breaskfastList);
			nutrition.setDinnerList(breaskfastList);
			nutrition.setLunchList(breaskfastList);
			model.put("nutrition", nutrition);
			session.setAttribute("nutrition", nutrition);
			getBMR(session);

		} catch (Exception e) {
throw new Exception("Error occured while opening dashboard"+e);
		}
	}
	private void populateUser(NutritionDetail nutrition,HttpSession session){
		User userForm=(User)session.getAttribute("userForm");
		nutrition.setUserForm(userForm);
	}
	
	
	@RequestMapping(method = RequestMethod.POST,value = "/fetchcalories")
	public String addFoodTypeBreakfast(@RequestParam(value="id",required=false)Integer id,
			@Valid @ModelAttribute("nutrition") NutritionDetail nutrition,BindingResult result ,
			Map<String, Object> model,HttpSession session)throws Exception{
			try{
				totalcalories(session, nutrition);
				if(totalCal<totalCalLimit){
					String foodType=nutrition.getBreaskfastList().get(id).getFoodType();
					String qty=nutrition.getBreaskfastList().get(id).getQty();
					Nutrition nut=userRegistrationService.fetchcalories(foodType);
					nut.setQty(qty);
					nut.setFoodType(foodType);
					if(nut!=null){
						if(calculateCalories(nut)){
							nutrition.getBreaskfastList().get(id).setCalories(nut.getCalories());
							nutrition.getBreaskfastList().get(id).setFiber(nut.getFiber());	
						}else{
							result.rejectValue("errorBreakfast","errorBreakfast.error","Addition of new food type not possible");
						}
						
					}
					
				}
				
					
				populateUser(nutrition,session);
				populateModel(model);
				model.put("nutrition", nutrition);
				
				session.setAttribute("nutrition", nutrition);
				return "RegistrationSuccess";
				
			}catch(Exception e){
			
				throw new Exception("Error occured in dashboard"+e);
				
			}
		//model.put("userForm", user);
		
		/*model.put("breakfastList", breakfastList);
		model.put("lunchList", lunchList);
		model.put("dinnerList", dinnerList);*/
		
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/fetchCaloriesLunch")
	public String addFoodTypeLunchCalories(@RequestParam(value="id",required=false)Integer id,
			@Valid @ModelAttribute("nutrition") NutritionDetail nutrition,BindingResult result ,
			Map<String, Object> model,HttpSession session)throws Exception{
		try{
			totalcalories(session, nutrition);
			if(totalCal<totalCalLimit){
				String foodType=nutrition.getLunchList().get(id).getFoodType();
				String qty=nutrition.getLunchList().get(id).getQty();
				Nutrition nut=userRegistrationService.fetchcalories(foodType);
				nut.setQty(qty);
				nut.setFoodType(foodType);
				if(nut!=null){
					if(calculateCalories(nut)){
						nutrition.getLunchList().get(id).setCalories(nut.getCalories());
						nutrition.getLunchList().get(id).setFiber(nut.getFiber());	
					}else{
						result.rejectValue("errorLunch","errorLunch.error","Addition of new food type not possible");
					}
					
				}
	
			}
			
						
			populateUser(nutrition,session);
			populateModel(model);
			model.put("nutrition", nutrition);
			
			session.setAttribute("nutrition", nutrition);
			//model.put("userForm", user);
			
			/*model.put("breakfastList", breakfastList);
			model.put("lunchList", lunchList);
			model.put("dinnerList", dinnerList);*/
			return "RegistrationSuccess";
		}catch(Exception e){
			throw new Exception("Error occured in dashboard"+e);
		}
		
		
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/fetchCaloriesDinner")
	public String addFoodTypeDinnerCalories(@RequestParam(value="id",required=false)Integer id,
			@Valid @ModelAttribute("nutrition") NutritionDetail nutrition,BindingResult result ,
			Map<String, Object> model,HttpSession session)throws Exception{
		
		try{
			totalcalories(session, nutrition);
			if(totalCal<totalCalLimit){
				String foodType=nutrition.getDinnerList().get(id).getFoodType();
				String qty=nutrition.getDinnerList().get(id).getQty();
				Nutrition nut=userRegistrationService.fetchcalories(foodType);
				nut.setQty(qty);
				nut.setFoodType(foodType);
				if(nut!=null){
					if(calculateCalories(nut)){
					nutrition.getDinnerList().get(id).setCalories(nut.getCalories());
					nutrition.getDinnerList().get(id).setFiber(nut.getFiber());
					}else{
						result.rejectValue("errorDinner","errorDinner.error","Addition of new food type not possible");
					}
				}
			}
			
			
			populateUser(nutrition,session);
			populateModel(model);
			model.put("nutrition", nutrition);
			
			session.setAttribute("nutrition", nutrition);
			//model.put("userForm", user);
			
			/*model.put("breakfastList", breakfastList);
			model.put("lunchList", lunchList);
			model.put("dinnerList", dinnerList);*/
			return "RegistrationSuccess";
		}catch(Exception e){
			throw new Exception("Error occured in dashboard"+e);
		}
		
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/addFoodType")
	public String addFoodTypeRow(@RequestParam(value="type",required=false)Integer type,
			@Valid @ModelAttribute("nutrition") NutritionDetail nutrition,BindingResult result ,
			Map<String, Object> model,HttpSession session)throws Exception{
		try{
			Nutrition nut=new Nutrition();
			if(nutrition==null){
				nutrition=(NutritionDetail)session.getAttribute("nutrition");
			}else if(nutrition.getBreaskfastList()==null){
				nutrition=(NutritionDetail)session.getAttribute("nutrition");
			}
			switch(type){
			case 0:
				nutrition.getBreaskfastList().add(nut);
				break;
			case 1:
				nutrition.getLunchList().add(nut);
			break;
			case 2:
				nutrition.getDinnerList().add(nut);
			}
			
			populateUser(nutrition,session);
			populateModel(model);
			model.put("nutrition", nutrition);
			
			return "RegistrationSuccess";
		}catch(Exception e){
			throw new Exception("Error occured in dashboard"+e);
		}
		
	}
	
	
	private boolean calculateCalories(Nutrition nutrition){
		
		int qty=Integer.parseInt(nutrition.getQty());
		double cal=Double.parseDouble(nutrition.getCalories());
		double fiber=Double.parseDouble(nutrition.getFiber());
		double calories=qty*cal;
		double tot=calories+totalCal;
		if(tot<totalCalLimit){
			nutrition.setCalories(String.valueOf(calories));
			nutrition.setFiber(String.valueOf(fiber));
			return true;
		}
		else{return false;}  
	
	}
	private void populateModel(Map<String, Object> model){
		List<String> selectbreakfastList=userRegistrationService.fetchFoodType("B");
		List<String> selectlunchList=userRegistrationService.fetchFoodType("L");
		List<String> selectdinnerList=userRegistrationService.fetchFoodType("D");
		List<String> selectQtyList=new ArrayList<String>();
		for(int i=0;i<11;i++){
			selectQtyList.add(String.valueOf(i));
			
		}
		
		model.put("selectQtyList", selectQtyList);
		model.put("breakfastfoodList", selectbreakfastList);
		model.put("lunchfoodlist", selectlunchList);
		model.put("dinnerfoodList", selectdinnerList);
	}
	
	private static void getBMR(HttpSession session){
		double total=0;
		User userForm=(User)session.getAttribute("userForm");
		total=Double.parseDouble(userForm.getBmiDetail().getBmr());
		totalCalLimit=total;
		
	}

	private void totalcalories(HttpSession session, NutritionDetail nutDetail) {
		totalCal=0;
		for (int i = 0; i < nutDetail.getBreaskfastList().size(); i++) {
			if (!StringUtils.isEmpty(nutDetail.getBreaskfastList().get(i)
					.getCalories())) {
				totalCal = totalCal
						+ Double.parseDouble(nutDetail.getBreaskfastList()
								.get(i).getCalories());
			}

		}
		for (int i = 0; i < nutDetail.getLunchList().size(); i++) {

			if (!StringUtils.isEmpty(nutDetail.getLunchList().get(i)
					.getCalories())) {
				totalCal = totalCal
						+ Double.parseDouble(nutDetail.getLunchList().get(i)
								.getCalories());
			}
		}
		for (int i = 0; i < nutDetail.getDinnerList().size(); i++) {
			if (!StringUtils.isEmpty(nutDetail.getDinnerList().get(i)
					.getCalories())) {
				totalCal = totalCal
						+ Double.parseDouble(nutDetail.getDinnerList().get(i)
								.getCalories());
			}
		}

	}
	
	@ExceptionHandler(Exception.class)
	  public ModelAndView handleError(HttpServletRequest req, Exception exception) {
	    

	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", exception);
	    mav.addObject("url", req.getRequestURL());
	    mav.setViewName("error");
	    return mav;
	  }
	
	
	

}
