/**
 * 
 */
package vn.com.nttdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.nttdata.dao.CriteriaDAO;
import vn.com.nttdata.model.Criterias;

/**
 * @author SPIDERMAN
 *
 */
@Service("criteriaService")
public class CriteriaServiceImpl implements CriteriaService {

	@Autowired
	public CriteriaDAO criteriaDAO;
	
	@Override
	public List<Criterias> getAllCriteria() {
		return criteriaDAO.findAllCriteria();
	}

}
