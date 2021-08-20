package src.test.user.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface MemberRepository extends JpaRepository<MemberVO, Long>{
	
    Optional<MemberVO> findByuId(String uId);

}
