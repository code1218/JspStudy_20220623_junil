package web.dto;

import domain.entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignupReqDto {
	private String name;
	private String email;
	private String username;
	private String password;
	
	public User toEntity() {
		return User.builder()
				.name(name)
				.email(email)
				.username(username)
				.password(password)
				.roles("ROLE_USER")
				.build();
	}
}
