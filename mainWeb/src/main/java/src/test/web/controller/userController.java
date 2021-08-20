package src.test.web.controller;


import java.net.URI;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import jdk.internal.org.jline.utils.Log;

import org.springframework.web.client.RestTemplate;

@RestController
public class userController {

	@GetMapping("/api/users/")
	public Object usersInfo(HttpServletRequest request, HttpServletResponse response) {
		
		URI url = URI.create("http://localhost:8090/api/user/members");

		
		return getResponseEntity(request, response, url);
	}
	
	@GetMapping("/api/user/")
	public Object userInfo(HttpServletRequest request, HttpServletResponse response) {
		
		URI url = URI.create("http://localhost:8090/api/user/member");
		
		return getResponseEntity(request, response,url);
	}
	
	
	public Object getResponseEntity(HttpServletRequest request, HttpServletResponse response, URI url) {
		ResponseEntity<?> responseEntity = null ;

		try {
			
			Stream<Cookie> cookieStream = Stream.of(request.getCookies()).filter(n -> n.getName().equals("jwtToken"));
			String jwtToken = cookieStream.findFirst().get().getValue();		
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(new MediaType(MediaType.APPLICATION_FORM_URLENCODED, Charset.forName("UTF-8")));
			headers.add("jwtToken", jwtToken);
			
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<?> requests = new HttpEntity<>(headers);
			responseEntity = restTemplate.exchange(url, HttpMethod.GET, requests, String.class);
		}catch(BadRequest e) {
			
			Cookie cookie = new Cookie("jwtToken", "123");
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
			return ResponseEntity.ok().body("Please Login.");
			
		}catch(NoSuchElementException | NullPointerException e) {
			
			System.out.println(this.getClass() +" ::: "+ e.getMessage());
			
			return ResponseEntity.ok().body("Please Login.");
		}
		return responseEntity.getBody() ;
	}
	
}
