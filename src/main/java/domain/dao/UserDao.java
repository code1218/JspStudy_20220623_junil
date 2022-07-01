package domain.dao;

import domain.entity.User;

public interface UserDao {
	public int save(User user) throws Exception;
	public User findUserByUsername(String username) throws Exception;
	public int modify(int user_code) throws Exception;
	public int remove(int user_code) throws Exception;
}
