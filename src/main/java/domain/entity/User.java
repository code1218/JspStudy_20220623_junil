package domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
	private int user_code;
	private String name;
	private String email;
	private String username;
	private String password;
	private String roles;
	private String provider;
	private String user_profile_img;
	private String user_address;
	private String user_phone;
	private int user_gender;
}
