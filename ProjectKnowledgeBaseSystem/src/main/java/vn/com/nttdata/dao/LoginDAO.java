package vn.com.nttdata.dao;

/*
@Author: Deepak Kumar
Check more tutorials at http://www.roseindia.net
*/
import vn.com.nttdata.model.*;

public interface LoginDAO {
	public boolean checkLogin(String userName, String userPassword);
}