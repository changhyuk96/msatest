package src.test.gate.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userDAO {
	
	public userVO getUser(String u_name);
}
