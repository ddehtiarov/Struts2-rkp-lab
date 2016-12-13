package org.dehtiarov.rkp.model;

import java.io.Serializable;

public class User implements Serializable {

    private Integer employeeId;
	private Integer age;
	private String fullName;
	private String email;
	private String login;
	private String password;
	private Role role;

	public User() {
	}

	public User(Integer employeeId, String fullName, String email, Integer age, Role role) {
		this.employeeId = employeeId;
		this.fullName = fullName;
		this.email = email;
		this.age = age;
		this.role = role;
	}

	public User(Integer employeeId, Integer age, String fullName, String email, String login, String password, Role role) {
		this.employeeId = employeeId;
		this.age = age;
		this.fullName = fullName;
		this.email = email;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
