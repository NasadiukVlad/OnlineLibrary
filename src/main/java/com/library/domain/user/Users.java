package com.library.domain.user;

import javax.persistence.*;

/**
 * Created by ���� on 03.12.2015.
 */


@Entity
public class Users {

    @Id
    // @SequenceGenerator(initialValue=1, allocationSize=1, name="users_seq", sequenceName="users_seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "username_id")
    private long usernameId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "selectedBooks")
    private String selectedBooks;

    @Column(name = "status")
    private String userStatus;

     public Users(String username, String password, String userEmail, String userStatus) {
        this.username = username;
        this.password = password;
        this.userEmail = userEmail;
        this.userStatus = userStatus;

    }

    public Users() {
    }

    public String getSelectedBooks() {
        return selectedBooks;
    }

    public void setSelectedBooks(String selectedBooks) {
        this.selectedBooks = selectedBooks;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }



    public long getUsernameId() {
        return usernameId;
    }

    public void setUsernameId(long usernameId) {
        this.usernameId = usernameId;
    }

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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

}
