package com.tts.techtalenttwitter.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.techtalenttwitter.model.User;

//The interface by which we access the database table that holds users (User objects)

//We create an interface that acts as a specification for what we want, and spring boot creates the actual repository
//To declare a Repository in Spring boot, we inherit from Repository

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	//Specifies that we are going to need to query by username
	User findByUsername(String username);
}
