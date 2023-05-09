package com.itvedant.petstore.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.itvedant.petstore.entities.NoPassword;
import com.itvedant.petstore.entities.User;

@RepositoryRestResource(excerptProjection = NoPassword.class)
//@Repository
public interface UserRepository 
    extends JpaRepository<User, Integer>{
    @RestResource(exported = false)
    Optional<User> findByEmail(String email);

    @RestResource(exported = false)
	<S extends User> S save(S entity);
}
