package com.library.dao.user;

import com.library.domain.book.Books;
import com.library.domain.user.UserFavoriteBooks;

import java.util.List;

/**
 * Created by Vlad on 15.03.2016.
 */
public interface UserFavoriteBookDao {
    void addFavoriteBook(UserFavoriteBooks userFavoriteBooks);
    List<UserFavoriteBooks> getAll();
    List<UserFavoriteBooks> getByUser(String username);
    void close();
}
