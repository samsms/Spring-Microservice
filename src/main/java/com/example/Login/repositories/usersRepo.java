package com.example.Login.repositories;

import com.example.Login.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface usersRepo extends JpaRepository<Users,Long> {
    Optional<Users> findByUsernameAndPassword(String username,String password);

    Optional<Users> findByUsername(String username);
}
