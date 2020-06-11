package com.app.gestionStock.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author mohamed
 *
 */
@Entity
@Table(name = "roles")
public class Roles {

	@Id
	@Column(name = "role")
	private String role;

	@ManyToMany(mappedBy = "roles")
	private Set<Users> users = new HashSet<>();

	/**
	 * @return the users
	 */
	public Set<Users> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<Users> users) {
		this.users = users;
	}


	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
