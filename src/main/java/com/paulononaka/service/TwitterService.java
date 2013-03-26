package com.paulononaka.service;

import java.util.List;

import twitter4j.TwitterException;

public interface TwitterService {

	public void post(String message) throws TwitterException;
	
	public List<String> getTweets() throws TwitterException;

}