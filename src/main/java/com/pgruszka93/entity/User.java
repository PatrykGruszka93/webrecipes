package com.pgruszka93.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "enabled")
	private boolean active;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_has_authorities",
			joinColumns = {@JoinColumn(name="users_id", referencedColumnName="id")},
			inverseJoinColumns = {@JoinColumn(name="authorities_id", referencedColumnName="id")})
	private Collection<Role> roles;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	private Collection<Recipe> recipes;


	public User() {
	}

	public User(String userName, String password, String email, boolean active, Collection<Role> roles) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.active = active;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Collection<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(Collection<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", active=" + active +
				", roles=" + roles +
				'}';
	}
}
