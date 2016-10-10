/**
 * 
 */
package vn.com.nttdata.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.com.nttdata.model.Users;

/**
 * @author SPIDERMAN
 *
 */
@Repository("registerDAO")
public class RegisterDAOImpl implements RegisterDAO {
	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public boolean checkAccount(String username) {
		System.out.println("In Check username");
		Session session = sessionFactory.openSession();
		boolean userFound = false;
		try {
			
			Criteria cr = session.createCriteria(Users.class);
			cr.add(Restrictions.eq("username", username));
			List list = cr.list();

			if ((list != null) && (list.size() > 0)) {
				userFound = true;
			}
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		
		return userFound;
	}

	@Override
	public void registerAccount(String username, String password) {
		System.out.println("In Check username");
		Session session = sessionFactory.openSession();
		// Insert using Hibernate Query Language
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		try {
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		

		
	}

}
