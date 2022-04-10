package com.ravi.githubapi.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ravi.githubapi.model.PullRequest;
import com.ravi.githubapi.processing.FilterDetails;

@Service
public class ServiceLayer {

	private RestTemplate restTemplate;
	private FilterDetails filterDetails;

	@Autowired
	public ServiceLayer(RestTemplate restTemplate, FilterDetails filterDetails) {
		this.restTemplate = restTemplate;
		this.filterDetails = filterDetails;
	}

	public List<PullRequest> callAPI() throws ParseException {
		String s = restTemplate.getForObject(
				"https://api.github.com/repos/paypal/paypal-messaging-components/pulls?state=open",
				String.class);

		/*
		 * Passes the output string from API call and returns a list of PullRequests
		 * from getPullDetails method in com.ravi.githubapi.processing package
		 */
		List<PullRequest> pr = filterDetails.getPullDetails(s);
		return pr;
	}

}
