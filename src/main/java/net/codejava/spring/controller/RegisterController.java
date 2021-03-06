package net.codejava.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.codejava.spring.model.User;
import net.codejava.spring.service.UserRegistrationService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {
	private static Logger LOGGER = LogManager.getLogger(RegisterController.class);

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

	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		User userForm = new User();		
		model.put("userForm", userForm);
		
		
		populateModel(model);
		
		
		return "Registration";
	}
	private void populateModel(Map<String, Object> model){
		List<String> heightfeetList = new ArrayList<String>();
		for(int i=1;i<=12;i++){
			heightfeetList.add(String.valueOf(i));
		}
		model.put("heightfeetList", heightfeetList);
		
		List<String> heightinchList = new ArrayList<String>();
		for(int i=0;i<12;i++){
			heightinchList.add(String.valueOf(i));
		}
		model.put("heightinchList", heightinchList);
		List<String> genderList = new ArrayList<String>();
		genderList.add("Male");
		genderList.add("Female");
		model.put("genderList", genderList);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@Valid @ModelAttribute("userForm") User user,BindingResult result ,
			Map<String, Object> model, HttpSession session) {
		if (result.hasErrors()) {
			populateModel(model);
			return "Registration";
		}else		
		if (userRegistrationService.verifyUser(user.getUsername())) {
			result.rejectValue("erroralreadyExist", "erroralreadyExist.error",
					"User Name Already Exist");
			populateModel(model);
			return "Registration";
		} else {
			userRegistrationService.submitUser(user);
			session.setAttribute("userForm", user);
		}

		return "redirect:RegistrationSuccess";
	}
	@ExceptionHandler(Exception.class)
	  public ModelAndView handleError(HttpServletRequest req, Exception exception) {
	    

	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", exception);
	    mav.addObject("url", req.getRequestURL());
	    mav.setViewName("error");
	    LOGGER.error("Exception occured while registering:"+exception);
	    return mav;
	  }
}
