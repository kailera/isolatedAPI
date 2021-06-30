package com.kailera.isolated.repositories;

import com.kailera.isolated.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select c from User c  where c.email = :email")
    User findByEmail(@Param("email") String email);


}
