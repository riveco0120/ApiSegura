package com.DEMOJWT.demo.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * User class
 *
 * @version 0.0.1
 * @since 0.0.1
 */
@Document(value = "user")
public class User {

    @Id
    private String id;
    private String user;
    private String pwd;
    private String token;

    public User(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
    }

    public User() {
    }

    public String id() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String pwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String token() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", pwd='" + pwd + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
