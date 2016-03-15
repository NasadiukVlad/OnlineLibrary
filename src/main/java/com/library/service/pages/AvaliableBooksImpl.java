package com.library.service.pages;

import com.library.dao.book.BooksJpaDao;
import com.library.domain.book.Books;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Vlad on 14.03.2016.
 */
public class AvaliableBooksImpl implements AvaliableBooks {

    @Override
    public ArrayList getAvaliableBooks() {
        BooksJpaDao booksJpaDao = new BooksJpaDao();
        Books books = new Books();
        List<Books> booksList = booksJpaDao.getAll();

        ArrayList avaliableBooks = new ArrayList();

        for (int i = 0; i < booksList.size(); i++) {
            HashMap items = new HashMap();
            items.put("title", booksList.get(i).getTitle());
            items.put("description", booksList.get(i).getDescription());
            items.put("author", booksList.get(i).getAuthor());
            avaliableBooks.add(items);

        }

        return avaliableBooks;

    }

    @Override
    public ArrayList getSearchingBooks(String title) {
        BooksJpaDao booksJpaDao = new BooksJpaDao();
        Books books = new Books();

        List<Books> booksList = booksJpaDao.getByTitle(title);

        ArrayList searchingBooks = new ArrayList();

        for (int i = 0; i < booksList.size(); i++) {
            HashMap items = new HashMap();
            items.put("title", booksList.get(i).getTitle());
            items.put("description", booksList.get(i).getDescription());
            items.put("author", booksList.get(i).getAuthor());
            searchingBooks.add(items);
        }

        return searchingBooks;
    }
}
