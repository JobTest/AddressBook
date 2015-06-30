package com.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * @author Lazarchuk Alex
 * @version 1.0
 */

@Entity
@Table(name = "users")
public class Contact {

    @Id
    @Column(name = "USERNAME")
    @NotNull
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FIO")
    private String fio;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "TELEPHONE")
    private String telephone;

    @Column(name = "ORGANIZATION")
    private String organization;

    @Column(name = "POSITION")
    @Enumerated(EnumType.STRING)
    private Position position;

//    @Column(name = "ENABLED")
//    private boolean enabled;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

//    public boolean getEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
}
