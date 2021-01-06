package com.stg.elap.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleModel implements Serializable {

	private static final long serialVersionUID = 4907699581716085528L;

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "NAME", length = 20, nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private Collection<UserModel> users;
	
	@ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@JoinTable(name="roles_authorities"
			, joinColumns = @JoinColumn(name="roles_id", referencedColumnName = "id")
			, inverseJoinColumns = @JoinColumn(name="authorities_id", referencedColumnName = "id"))
	private Collection<AuthorityModel> authorities;
	
	public RoleModel() {
		
	}
	
	public RoleModel(String role) {

	this.name = role;
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

	public Collection<UserModel> getUsers() {
		return users;
	}

	public void setUsers(Collection<UserModel> users) {
		this.users = users;
	}

	public Collection<AuthorityModel> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<AuthorityModel> authorities) {
		this.authorities = authorities;
	}


}
