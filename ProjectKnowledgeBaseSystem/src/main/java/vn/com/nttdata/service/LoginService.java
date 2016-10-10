package vn.com.nttdata.service;
/*
@Author: Deepak Kumar
Check more tutorials at http://www.roseindia.net
*/
import vn.com.nttdata.model.*;

public interface LoginService{    
       public boolean checkLogin(String userName, String userPassword);
}