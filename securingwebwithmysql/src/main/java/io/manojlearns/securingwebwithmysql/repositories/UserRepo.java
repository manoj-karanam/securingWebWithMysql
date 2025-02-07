package io.manojlearns.securingwebwithmysql.repositories;


import io.manojlearns.securingwebwithmysql.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    public UserDetails findByUsername(String username);
}
