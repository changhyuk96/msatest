package src.test.user.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memRepo;
	
	public List<MemberVO> findAll() {
		return memRepo.findAll();
	}
	
	public MemberVO findByU_Id(String u_Id) {
		return memRepo.findByuId(u_Id).get();
	}
	


}
