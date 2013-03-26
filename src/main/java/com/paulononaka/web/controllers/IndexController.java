package com.paulononaka.web.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.paulononaka.service.RegisterService;
import com.paulononaka.service.TwitterService;

public class IndexController implements Controller {

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
		registerService.getList();
		
		PagedListHolder<?> pagedListHolder = new PagedListHolder(registerService.getList());
		
		/*
		PagedListHolder<?> pagedListHolder = (PagedListHolder<?>) request.getSession().getAttribute("registerList");
		
		if (pagedListHolder == null) {
			pagedListHolder = new PagedListHolder(registerService.getList());
		} else {
			String page = (String) request.getParameter("page");
			if ("next".equals(page)) {
				pagedListHolder.nextPage();
			} else if ("previous".equals(page)) {
				pagedListHolder.previousPage();
			}
		}

		request.getSession().setAttribute("registerList", pagedListHolder);
		 */
		
		model.put("registerList", pagedListHolder);
		model.put("tweetsList", twitterService.getTweets());
		return new ModelAndView("index", model);
	}

}