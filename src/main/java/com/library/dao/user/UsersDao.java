package com.library.dao.user;

import com.library.domain.user.Users;

import java.util.List;

/**
 * Created by ���� on 03.01.2016.
 */
public interface UsersDao {
    void addUser(Users user);
    List<Users> getAll();
    Users getByLogin(String login);
    void close();
}
