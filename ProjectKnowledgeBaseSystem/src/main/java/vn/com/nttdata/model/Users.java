package vn.com.nttdata.model;
/*
@Author: Deepak Kumar
Check more tutorials at http://www.roseindia.net
*/
import java.util.List;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Embeddable;

@Entity
@Table(name = "users")
@SuppressWarnings("serial")
public class Users implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 11 )
	private Long id;
	
	@Column(name = "username")
	String username;

	@Column(name = "pwd")
	String password;


	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	} 



	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}