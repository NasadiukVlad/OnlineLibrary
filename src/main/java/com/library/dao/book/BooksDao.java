package com.library.dao.book;

import com.library.domain.book.Books;
import com.library.domain.user.Users;

import java.util.List;

/**
 * Created by Vlad on 13.03.2016.
 */
public interface BooksDao {
    void addBook(Books book);
    List<Books> getAll();
    Books getByLogin(String login);
    void close();
}
