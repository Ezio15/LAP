package com.stg.elap.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class AuthorityModel implements Serializable{


	private static final long serialVersionUID = -85594207460375129L;
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "NAME", length = 20, nullable = false)
	private String name;

	
	@ManyToMany(mappedBy = "authorities")
	private Collection<RoleModel> roles;

	
	public AuthorityModel() {}

	public AuthorityModel(String authority) {
	
		this.name = authority;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Collection<RoleModel> getRoles() {
		return roles;
	}


	public void setRoles(Collection<RoleModel> roles) {
		this.roles = roles;
	}
	
	
}
