package src.test.gate.util;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;

@Service
public class serviceUtil {
	
	private final String secret_key = "sec_api_token";

	// Access 토큰 유효성 검사
	public void validateAccessToken(String token) throws Exception{
		Jwts.parser().setSigningKey(secret_key).parseClaimsJws(token);
	}

}
