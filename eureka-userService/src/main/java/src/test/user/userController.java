package src.test.user;

import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import src.test.user.config.JwtBuilder;
import src.test.user.data.MemberService;

@RequestMapping("/api/user")
@RestController
public class userController {
	
	ObjectMapper mapper = new ObjectMapper();
	RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	JwtBuilder jwtBuilder;
	
	@GetMapping("/members")
	public Object members(HttpServletRequest request) {
		
		return memberService.findAll();
	}
	
	@GetMapping("/member")
	public Object member(HttpServletRequest request) {
		
		String jwtSubject = jwtBuilder.getSubject(request.getHeader("jwtToken"));
		
		return memberService.findByU_Id(jwtSubject);
	}
	
}
