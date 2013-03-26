package com.paulononaka.web.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.paulononaka.model.Register;
import com.paulononaka.service.RegisterService;

public class UpdateRegisterController implements Controller {

	private RegisterService registerService;

	@Autowired
	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map<String, Object> model = new HashMap<String, Object>();

		Long id = Long.parseLong(request.getParameter("registerId"));
		Register register = registerService.getRegister(id);

		model.put("title", "Update Register");
		model.put("register", register);
		return new ModelAndView("registerEdit", model);
	}

}