package com.example.reposirory.login;

import com.example.model.login.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, String> {

    User findByUserName(String userName);
}
