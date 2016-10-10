/**
 * 
 */
package vn.com.nttdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.nttdata.dao.RegisterDAO;

/**
 * @author SPIDERMAN
 *
 */
@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDAO registerDAO;
	
	/**
	 * @param registerDAO the registerDAO to set
	 */
	public void setRegisterDAO(RegisterDAO registerDAO) {
		this.registerDAO = registerDAO;
	}
	@Override
	public boolean checkAccount(String username) {
		return registerDAO.checkAccount(username);
	}

	@Override
	public void registerAcount(String username, String password) {
		registerDAO.registerAccount(username, password);
		
	}
}
