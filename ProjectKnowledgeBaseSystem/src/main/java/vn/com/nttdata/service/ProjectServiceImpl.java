/**
 * 
 */
package vn.com.nttdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.nttdata.dao.LoginDAO;
import vn.com.nttdata.dao.ProjectDAO;
import vn.com.nttdata.model.Projects;

/**
 * @author SPIDERMAN
 *
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDAO;
	
	@Override
	public List<Projects> listAllProject() {
		return projectDAO.listAllProject();
	}

	/**
	 * @param projectDAO the projectDAO to set
	 */
	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

}
