package com.poslovna.model.users.access;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(unique = true, nullable = false)
	@Size(max = 30)
	@NotEmpty
	private String roleName;

	@Column(name="permissions")
	@ManyToMany
	@JoinTable(
		      name="role_permission",
		      joinColumns= @JoinColumn (name="role_id", referencedColumnName="id"), 
		      inverseJoinColumns=@JoinColumn (name="permission_id", referencedColumnName="id"))
	private Collection<Permission> permissions;
	
	public Role() {
		this.permissions = new ArrayList<Permission>();
	}

	public Role(String roleName, Collection<Permission> permissions) {
		super();
		this.roleName = roleName;
		this.permissions = permissions;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Collection<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Collection<Permission> permissions) {
		this.permissions = permissions;
	}

	
	
}
