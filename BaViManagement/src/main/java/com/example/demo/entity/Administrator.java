package com.example.demo.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Administrator {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer id;
	  	  
	  
	  @Column(name = "first_name", nullable = false, length = 50)
	  private String firstName;
	  
	  @Column(name = "last_name", nullable = false, length = 50)
	  private String lastName;
	  @JsonFormat(pattern = "dd/MM/yyyy")
	  @Column(name = "DOB", nullable = true)
	  private Date DOB;
	  
	  @Column(name = "email", nullable = false, length = 100)
	  private String email;
	  
	  @Column(name = "username", nullable = false, length = 100)
	  private String username;
	  
	  @Column(name = "password", nullable = false, length = 100)
	  private String password;
	  
	  @ElementCollection(fetch = FetchType.EAGER)
	  List<Role> roles;
	  
	  
	  

	public Administrator() {
		super();
	}

	public Administrator(Integer id, String firstName, String lastName, Date dOB, String email, String username,
			String password, List<Role> roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		DOB = dOB;
		this.email = email;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
	  
}
