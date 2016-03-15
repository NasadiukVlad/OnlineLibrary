package com.library.service.pages;

import com.library.dao.book.BooksJpaDao;
import com.library.dao.user.UserFavoriteBookJpaDao;
import com.library.domain.book.Books;
import com.library.domain.user.UserFavoriteBooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Vlad on 15.03.2016.
 */
public class FavoriteBooksImpl implements FavoriteBooks {

    @Override
    public ArrayList getFavoriteBooks(String username) {

        UserFavoriteBookJpaDao userFavoriteBookJpaDao = new UserFavoriteBookJpaDao();
        UserFavoriteBooks userFavoriteBooks = new UserFavoriteBooks();

        List<UserFavoriteBooks> favoriteBooksList = userFavoriteBookJpaDao.getByUser(username);

        ArrayList favoriteBooks = new ArrayList();

        for (int i = 0; i < favoriteBooksList.size(); i++) {
            HashMap items = new HashMap();
            items.put("title", favoriteBooksList.get(i).getTitle());
            items.put("description", favoriteBooksList.get(i).getDescription());
            items.put("author", favoriteBooksList.get(i).getAuthor());
            items.put("filePath",favoriteBooksList.get(i).getFilePath());
            favoriteBooks.add(items);
        }

        return favoriteBooks;

    }
}
