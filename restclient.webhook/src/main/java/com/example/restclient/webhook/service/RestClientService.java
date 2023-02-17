package com.example.restclient.webhook.service;


import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClientService {
	
	@Autowired
	private final RestTemplate restTemplate;
	
	public RestClientService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	
	
	public String consumeAPI() {
		
		String plainCreds = "admin:142E!LmT";
		byte[] plainCredsBytes = plainCreds.getBytes();
		String base64CredsBytes = Base64.encodeBase64String(plainCredsBytes);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64CredsBytes);
		String URL = "http://localhost:8080/ems/api/v5/roles/bb7ee801-2738-4022-80a0-a54c48c315cd";
		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<String> response = restTemplate.exchange(URL,HttpMethod.GET,request, String.class);
		String json = response.getBody();
		return json;
	}

	
}
