package vn.com.nttdata.dao;
/*
@Author: Deepak Kumar
Check more tutorials at http://www.roseindia.net
*/
import vn.com.nttdata.model.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Query;
import java.util.List;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
     
			 
       @Resource(name="sessionFactory")
       protected SessionFactory sessionFactory;

       public void setSessionFactory(SessionFactory sessionFactory) {
              this.sessionFactory = sessionFactory;
       }
      
       protected Session getSession(){
              return sessionFactory.openSession();
       }

       public boolean checkLogin(String username, String password){
			System.out.println("In Check login");
			Session session = sessionFactory.openSession();
			boolean userFound = false;
						
			Criteria cr = session.createCriteria(Users.class);
			cr.add(Restrictions.eq("username", username));
			cr.add(Restrictions.eq("password", password));
			List list = cr.list();

			if ((list != null) && (list.size() > 0)) {
				userFound= true;
			}

			session.close();
			return userFound;              
       }
}