package com.mm.java.software.thebook.repository;

import com.mm.java.software.thebook.model.UserName;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserNameRepository extends CrudRepository<UserName, Integer> {


    @Query("select u from UserName u where u.email = ?1")
    Optional<UserName> findByEmail(String email);


}
