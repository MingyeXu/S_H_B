package dao;

import java.util.Vector;

import dto.User;
import exceptions.UserDaoException;

public interface UserDao {
	
	public String insert(User user) throws UserDaoException;	
	public Vector<User> getExportInfo() throws UserDaoException;
	public void delete(String del_id)throws UserDaoException;

}
