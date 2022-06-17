package com.example.reposirory.login;

import com.example.model.login.User;
import com.example.model.login.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Integer> {

    List<UserRole> findByUser(User user);
}
