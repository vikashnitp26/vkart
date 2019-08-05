package com.vkart.dao;

import java.util.List;
import com.vkart.model.*;

public interface UserDAO {

	public List<User> list();

	public User get(int id);
	
	public User get(String uname);

	public void saveOrUpdate(User user);

	public void delete(int id);

}
