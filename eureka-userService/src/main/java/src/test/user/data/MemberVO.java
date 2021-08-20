package src.test.user.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="m_user_table")
public class MemberVO {

	
	@Id
	@Column(name="u_id")
	private String uId;
	private String u_name;
	private String u_password;
	private String u_reg_date;
	
}
