/**
 * 
 */
package vn.com.nttdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author SPIDERMAN
 *
 */
@Entity
@Table(name = "projects")
@SuppressWarnings("serial")
public class Projects {
	@Id
	@Column(name = "project_name")
	private String projectName;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "scope")
	private String scope;
	
	@Column(name = "project_type")
	private String type;
	
	@Column(name = "method")
	private String method;
	
	@Column(name = "technical")
	private String technical;
	
	@Column(name = "performance")
	private int performance;
	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}
	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * @return the scope
	 */
	public String getScope() {
		return scope;
	}
	/**
	 * @param scope the scope to set
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * @return the technical
	 */
	public String getTechnical() {
		return technical;
	}
	/**
	 * @param technical the technical to set
	 */
	public void setTechnical(String technical) {
		this.technical = technical;
	}
	/**
	 * @return the performance
	 */
	public int getPerformance() {
		return performance;
	}
	/**
	 * @param performance the performance to set
	 */
	public void setPerformance(int performance) {
		this.performance = performance;
	}
	
	
}
