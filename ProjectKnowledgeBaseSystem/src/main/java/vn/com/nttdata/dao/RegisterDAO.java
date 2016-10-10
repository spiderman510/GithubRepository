/**
 * 
 */
package vn.com.nttdata.dao;

/**
 * @author SPIDERMAN
 *
 */
public interface RegisterDAO {
	public boolean checkAccount(String username);
	public void registerAccount(String username, String password);
}
