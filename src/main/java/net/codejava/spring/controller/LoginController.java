package net.codejava.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.codejava.spring.model.User;
import net.codejava.spring.model.UserLogin;
import net.codejava.spring.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	
	@Autowired
	@Qualifier("loginService")
	private LoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET,value = "/home")
	public String viewHome(Map<String, Object> model){
		return "home";
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/login")
	public String viewLoginForm(Map<String, Object> model) {
		UserLogin loginform = new UserLogin();		
		model.put("loginform", loginform);
		
		
		
		return "login";
	}
	 @RequestMapping(value = "/dologin", method = RequestMethod.POST)
	    public String doLogin(@Valid @ModelAttribute("loginform") UserLogin loginform,
			BindingResult result, Map<String, Object> model, HttpSession session)throws Exception {
		try {
			if (result.hasErrors()) {
				return "login";
			} else {
				if (!loginService.getLoginService(loginform)) {
					result.rejectValue("userName", "error.userName",
							"User Not found");
					return "login";
				}
				session.removeAttribute("userForm");
				User user = loginService
						.getLoginDetail(loginform.getUserName());
				model.put("userForm", user);
				session.setAttribute("userForm", user);
			}

		} catch (Exception e) {
			throw new Exception("Error Occured while Signing in "+e);
		}

		return "redirect:/RegistrationSuccess";
	}
	 
	 @ExceptionHandler(Exception.class)
	  public ModelAndView handleError(HttpServletRequest req, Exception exception) {
	    

	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", exception);
	    mav.addObject("url", req.getRequestURL());
	    mav.setViewName("error");
	    return mav;
	  }
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	 

}
