package com.paulononaka.web.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.paulononaka.service.RegisterService;
import com.paulononaka.service.TwitterService;

public class DeleteRegisterController implements Controller {

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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map model = new HashMap();
		
		Long id = Long.parseLong(request.getParameter("registerId"));
		registerService.delete(id);

		/*
		PagedListHolder<?> pagedListHolder = (PagedListHolder<?>) request.getSession().getAttribute("registerList");

		List registerList = pagedListHolder.getSource();
		for (Iterator iterator = registerList.iterator(); iterator.hasNext();) {
			Register register = (Register) iterator.next();
			if (register.getId().equals(id)) {
				registerList.remove(register);
				break;
			}
		}
		pagedListHolder.setSource(registerList);
		*/
		
		PagedListHolder<?> pagedListHolder = new PagedListHolder(registerService.getList());
		//request.getSession().setAttribute("registerList", pagedListHolder);
		model.put("registerList", pagedListHolder);
		model.put("tweetsList", twitterService.getTweets());
		return new ModelAndView("index", model);
	}

}