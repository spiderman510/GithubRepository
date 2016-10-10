/**
 * 
 */
package vn.com.nttdata.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import vn.com.nttdata.model.Projects;

/**
 * @author SPIDERMAN
 *
 */
@Repository("projectDAO")
public class ProjectDAOImpl implements ProjectDAO {
	@Resource(name="sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
           this.sessionFactory = sessionFactory;
    }
   
    protected Session getSession(){
           return sessionFactory.openSession();
    }
    
	@Override
	public List<Projects> listAllProject() {
		Session session = sessionFactory.openSession();
		List<Projects> result = new ArrayList<Projects>();
					
		Criteria cr = session.createCriteria(Projects.class);
		List list = cr.list();
		result = list;

		session.close();
		return result;  
	}
	
}
