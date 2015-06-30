package com.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * @author Lazarchuk Alex
 * @version 1.0
 */

@Entity
@Table(name = " user_roles")
public class Role {

    @Id
    @Column(name = "USER_ROLE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Integer user_role_id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "ROLE")
    private String role;

    public Integer getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(Integer user_role_id) {
        this.user_role_id = user_role_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
