package config;

import domain.dao.UserDao;
import domain.dao.UserDaoImpl;
import lombok.Getter;
import service.UserService;
import service.UserServiceImpl;

@Getter
public class ServletContextConfig {
	private static ServletContextConfig instance = null;
	
	/*
	 * Custom IoC (객체관리)
	 */
	
	//Repository
	private UserDao userDao;
	
	//Service
	private UserService userService;
	
	private ServletContextConfig() {}
	
	public static ServletContextConfig getInstance() {
		if(instance == null) {
			instance = new ServletContextConfig();
			instance.setIoC();
		}
		
		return instance;
	}
	
	private void setIoC() {
		if(userDao == null) {
			userDao = new UserDaoImpl();
		}
		
		if(userService == null) {
			userService = new UserServiceImpl();
		}
	}
	
}
