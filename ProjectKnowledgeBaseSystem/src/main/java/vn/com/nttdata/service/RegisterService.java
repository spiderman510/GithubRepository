/**
 * 
 */
package vn.com.nttdata.service;

/**
 * @author SPIDERMAN
 *
 */
public interface RegisterService {
	public boolean checkAccount(String username);
	public void registerAcount(String username, String password);
}
