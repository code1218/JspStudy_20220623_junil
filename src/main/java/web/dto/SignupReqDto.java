package web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignupReqDto {
	private String name;
	private String email;
	private String username;
	private String password;
}
