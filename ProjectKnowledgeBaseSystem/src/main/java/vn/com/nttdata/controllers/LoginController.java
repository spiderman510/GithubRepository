package vn.com.nttdata.controllers;
/*
@Author: Deepak Kumar
Check more tutorials at http://www.roseindia.net
*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import vn.com.nttdata.form.LoginForm;
import vn.com.nttdata.model.Projects;
import vn.com.nttdata.service.*;
import vn.com.nttdata.uvo.UserValueObject;


@Controller
@RequestMapping("login")
public class LoginController {

	
	@Autowired
	public LoginService loginService;
	
	@Autowired
	public ProjectService projectService;

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result,
			Map model) {

		
		if (result.hasErrors()) {
			return "login";
		}
		
		boolean userExists = loginService.checkLogin(loginForm.getUsername(),loginForm.getPassword());
		if(userExists){
			model.put("loginForm", loginForm);
			
			List<Projects> projects = projectService.listAllProject();
			model.put("projectList", projects);
			UserValueObject.username = loginForm.getUsername();
			
			return "redirect:/registrationform";
		}else{
			result.rejectValue("username","invaliduser");
			return "login";
		}

	}

}
