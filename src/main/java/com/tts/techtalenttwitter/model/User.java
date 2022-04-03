package com.tts.techtalenttwitter.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//We're storing User in a database
//To wire up to the database, have to annotate user w/annotation from JPA

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	
	//In order for auto storing of Users to db there has to be a default constructor
	
	//Label this as our primary key
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;
	
	@Email(message="Please provide a valid email")
	@NotEmpty(message = "Please provde an email")
	private String email;

	@NotEmpty(message = "Please provide a username")
	@Length(min = 3, message = "Username must be at least 3 characters")
	@Length (max = 15, message = "Username cannot be longer than 15 characters")
	@Pattern(regexp="[^\\s]+", message = "Your username cannot contain spaces")
	private String username;

	@NotEmpty(message = "Please provide a password")
	@Length(min=5, message = "Password must be at least 5 characters")
	private String password;

	@NotEmpty(message = "Please provide your first name")
	private String firstName;

	@NotEmpty(message = "Please provide your last name")
	private String lastName;
	
	private int active;   //1 means account is enabled
	
	@CreationTimestamp
	private Date createdAt;
	
	//This "User" class will be mapped to a database entry
	//There is no good way to store an unlimited number of roles to a table entry
	
	@ManyToMany(cascade = CascadeType.ALL)
	//Automatically updates table when users and/or roles are deleted
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	//User database    ``````````         Role database
	//    id                                   id
	//   firstName                           role
	
	
	//user_role table .....
	//user_id, role_id
	//Will contain a set of relationships to connect users and roles

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="user_followers", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name = "follower_id"))
	private List<User> followers;

	@ManyToMany(mappedBy="followers")
	private List<User> following;

}
