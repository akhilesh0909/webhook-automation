package com.example.restclient.webhook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restclient.webhook.service.RestClientService;

@RestController
public class RestClientController {
	
	
	private final RestClientService restClientService;
	
	@Autowired
	public RestClientController(RestClientService restClientService) {
		this.restClientService = restClientService;
	}
	
	@GetMapping("/")
	public String getData() {
		return restClientService.consumeAPI();
	}

}
