package src.test.user.config;

import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Configuration
public class JwtBuilder {
	
	private String secret_key="sec_api_token";
	
	public Claims getClaims(String token) {
		
		try {
			Claims body = Jwts.parser().setSigningKey(secret_key).parseClaimsJws(token).getBody();
			
			return body;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String getSubject(String token) {
		
		return Jwts.parser().setSigningKey(secret_key).parseClaimsJws(token).getBody().getSubject();
	}
}
