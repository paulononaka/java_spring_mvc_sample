package com.paulononaka.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

@Component(value = "twitterService")
public class TwitterServiceImpl implements TwitterService {

	private static final String ERROR_POSTING_TWEETS = "Error occured while posting tweets to twitter";
	private static final String CONSUMER_KEY = "004uVh8KgGOnRSOgLXYNzQ";
	private static final String CONSUMER_SECRET = "tjZ1s1ktnleyGGBsyMy2mn12yYGZ56NaVjzhNrFPJf0";
	private static final String ACCESS_TOKEN = "322686319-WYRdtfGYqorUO2OgydURT5vCCL1ad9d0NY015lIr";
	private static final String ACCESS_TOKEN_SECRET = "hR95hjugEv6U0UJw0yQAypatHOKnCTelj0G4aItOM";

	private Twitter twitter;
	
	public TwitterServiceImpl() {
		Configuration configuration = new ConfigurationBuilder()
			.setOAuthConsumerKey(CONSUMER_KEY)
			.setOAuthConsumerSecret(CONSUMER_SECRET)
			.setOAuthAccessToken(ACCESS_TOKEN)
			.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET).build();

		twitter = new TwitterFactory(configuration).getInstance();
	}

	@Override
	public void post(String message) throws TwitterException {
		Status status = twitter.updateStatus(message);
		if (status.getId() == 0) {
			new TwitterException(ERROR_POSTING_TWEETS);
		}
	}

	public List<String> getTweets() throws TwitterException {
		List<String> l = new ArrayList<String>();
		List<Status> statuses = twitter.getUserTimeline();
		for (Status status : statuses) {
			l.add(status.getUser().getName() + " - " + status.getText());
		}
		return l;
	}
}
