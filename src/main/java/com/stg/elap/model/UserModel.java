package com.stg.elap.model;

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
@Table(name = "tbl_userdetails")
public class UserModel {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private long id;
	
	 @Column(name = "NAME")
	 public String name;
	 @Column(name = "EMAIL")
	public String email;
	 
	 @Column(name = "PASSWORD")
	 public String password;
	 
		@Column(name = "ROLE")
		 public String role;
		
		@ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
		@JoinTable(name="users_roles"
				, joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id")
				, inverseJoinColumns = @JoinColumn(name="roles_id", referencedColumnName = "id"))
		private Collection<RoleModel> roles;
	 
	 public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<RoleModel> getRoles() {
		return roles;
	}
	public void setRoles(Collection<RoleModel> roles) {
		this.roles = roles;
	}

}
