package com.paulononaka.web.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.paulononaka.model.Register;
import com.paulononaka.service.RegisterService;
import com.paulononaka.service.TwitterService;

@SuppressWarnings("deprecation")
public class SaveRegisterController extends AbstractCommandController {

	private static String MESSAGE = " acabou de se cadatrar no site http://sambatech1.appspot.com";
	private RegisterService registerService;
	private TwitterService twitterService;

	@Autowired
	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}
	
	@Autowired
	public void setTwitterService(TwitterService twitterService) {
		this.twitterService = twitterService;
	}

	public SaveRegisterController() {
		this.setCommandClass(Register.class);
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object form,
			BindException errors) throws Exception {

		Map<String, Object> model = new HashMap<String, Object>();

		Register register = (Register) form;

		boolean newRegister = register.getId() == null;
		
		registerService.save(register);

		// request.getSession().setAttribute("registerList", null);
		
		if (newRegister) {
			if (register.getTwitter() != null && !register.getTwitter().isEmpty()) {
				twitterService.post(register.getTwitter() + MESSAGE);
			} else {
				twitterService.post(register.getName() + MESSAGE);
			}
		}

		model.put("title", "Update Register");
		model.put("register", register);
		return new ModelAndView("registerEdit", model);
	}

}