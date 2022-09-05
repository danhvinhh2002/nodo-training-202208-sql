package edu.hanoi.service.model;

import javax.persistence.*;

@Entity
@Table(name="V_USER",uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class User {
//    @Id
//    @Column(name = "username",unique = true,nullable = false)
    private String username;
//    @Column(name = "password",nullable = false)
    private String password;
//    @Column(name = "age")
    private Integer age;
//    @Column(name = "email")
    private String email;
//    @Column(name = "groupId",nullable = false)
    private Integer idGroup;

    public User() {
    }

    public User(String username, String password, Integer age, String email, Integer idGroup) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.email = email;
        this.idGroup = idGroup;
    }
    @Id
    @Column(name = "username",unique = true,nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(name = "password",nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "groupId",nullable = false)
    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }
}
