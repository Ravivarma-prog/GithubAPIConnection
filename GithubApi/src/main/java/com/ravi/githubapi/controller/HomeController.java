package com.ravi.githubapi.controller;

import java.awt.PageAttributes.MediaType;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.githubapi.model.PullRequest;
import com.ravi.githubapi.service.ServiceLayer;

@RestController
public class HomeController {
	
	//To make API call
	private ServiceLayer serviceLayer;
	
	@Autowired
	public HomeController(ServiceLayer serviceLayer)
	{
		this.serviceLayer = serviceLayer;
	}
	
	@RequestMapping("/")
	public String show() {
		return "hello";
	}
	
	@RequestMapping(value = "/getpr")
	public List<PullRequest> getout() throws ParseException {
		List<PullRequest> pr = serviceLayer.callAPI();
		return pr;
	}
	
}
