package vn.com.nttdata.controllers;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.com.nttdata.form.Registration;
import vn.com.nttdata.service.RegisterService;

@Controller
@RequestMapping("/registrationform.html")
public class RegistrationController {
	@Autowired
	private RegistrationValidation registrationValidation;
	
	@Autowired
	private RegisterService registerService;
	
	/**
	 * @param registerService the registerService to set
	 */
	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	public void setRegistrationValidation(
			RegistrationValidation registrationValidation) {
		this.registrationValidation = registrationValidation;
	}

	// Display the form on the get request
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(Map model) {
		Registration registration = new Registration();
		model.put("registration", registration);
		return "registrationform";
	}

	// Process the form.
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@Valid Registration registration,
			BindingResult result) {
		// set custom Validation by user
		registrationValidation.validate(registration, result);
		if (result.hasErrors()) {
			return "registrationform";
		}
		
		if (registerService.checkAccount(registration.getUserName()) == false) {
			registerService.registerAcount(registration.getUserName(), registration.getPassword());
		} else {
			return "registrationform";
		}
		return "registrationsuccess";
	}
}
