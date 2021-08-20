package src.test.gate.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

	@Autowired
	private userDAO dao;
	
	public userVO getUser(String u_name){
		return dao.getUser(u_name);
	}
		
}
