package com.example.model.login;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_role", uniqueConstraints = { @UniqueConstraint(name = "USER_ROLE_UK", columnNames = { "username", "role_id" }) })
public class UserRole implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int roleId;
//

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "roleId")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "userName")
    private User user;


    public UserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
