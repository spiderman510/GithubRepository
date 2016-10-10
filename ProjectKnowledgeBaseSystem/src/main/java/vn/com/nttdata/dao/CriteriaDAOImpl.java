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

import vn.com.nttdata.model.Criterias;
import vn.com.nttdata.model.Projects;

/**
 * @author SPIDERMAN
 *
 */
@Repository("criteriaDAO")
public class CriteriaDAOImpl implements CriteriaDAO {
	
	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public List<Criterias> findAllCriteria() {
		Session session = sessionFactory.openSession();
		List<Criterias> result = new ArrayList<Criterias>();
					
		Criteria cr = session.createCriteria(Criterias.class);
		List list = cr.list();
		result = list;

		session.close();
		return result;  
	}

}
