package vn.com.nttdata.service;

import javax.naming.NamingException;

/*
@Author: Deepak Kumar
Check more tutorials at http://www.roseindia.net
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.nttdata.dao.*;
import vn.com.nttdata.ldap.LDAPManager;
import vn.com.nttdata.ldap.LdapManagement;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	public boolean checkLogin(String username, String password) {
		System.out.println("In Service class...Check Login");

		/*String LDAPip = LdapManagement.ldapIp;
		String LDAPdomain = LdapManagement.ldapDomain;
		String LDAPusr = LdapManagement.ldapUser;
		String LDAPpw = LdapManagement.ldapPwd;

		try {
			LDAPManager ldap = new LDAPManager(LDAPip, 389, LDAPdomain + "\\" + LDAPusr, LDAPpw);
			// Check is belong to group Managers
			boolean isManagers = ldap.userInGroup(username, password);

			// Check username and password
			if (ldap.isValidUser(username, password) && (isManagers == true || checkAdmin(username))) {
				return true;
			} else {
				return false;
			}
		} catch (NamingException e) {
			System.out.println("Connect Ldap failed");
		}*/

		return loginDAO.checkLogin(username, password);
	}

	/**
	 * check Admin
	 * 
	 * @param userId
	 * @return boolean
	 */
	private boolean checkAdmin(String userId) {
		// TODO Auto-generated method stub
		String property = LdapManagement.ldapAdmin;
		String[] listAdmin = property.replace(" ", "").split(",");
		for (int i = 0; i < listAdmin.length; i++) {
			if (listAdmin[i].equals(userId)) {
				return true;
			}
		}
		return false;
	}
}