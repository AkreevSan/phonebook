package ru.itpark.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="authorizations")
public class Authorization implements Serializable {

    private static final long serialVersionUID = 24112016L;

    @Id
    @Column(name = "login", unique = true, nullable = false, length = 45)
    private String login;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name="role",nullable = false, length = 60)
    private String role;

    public String getRole() {
        return role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "User{" +
                "log =" + login +
                ", pass =" + password + '\'' +
                ", role =" + role +
                "}";
    }
}
