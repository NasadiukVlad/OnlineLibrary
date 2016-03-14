package com.library.dao.book;

import com.library.domain.book.Books;
import com.library.domain.user.Users;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 13.03.2016.
 */
public class BooksJpaDao implements BooksDao {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public BooksJpaDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("OnlineLibraryPersistance");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    @Override
    public void addBook(Books book) {
        try {
            transaction.begin();
            entityManager.persist(book);
            transaction.commit();

        } catch (Exception exception) {
            transaction.rollback();

        } finally {
            close();
        }
    }

    @Override
    public List<Books> getAll() {
        List<Books> allBooksList = new ArrayList<>();

        try {
            transaction.begin();
            TypedQuery<Books> allUsersQueryResult =
                    entityManager.createQuery("SELECT books FROM Books books", Books.class);
            transaction.commit();
            allBooksList = allUsersQueryResult.getResultList();

        } catch (Exception exception) {
            transaction.rollback();

        } finally {
            close();
        }

        return allBooksList;
    }

    @Override
    public List<Books> getByTitle(String title) {
        List<Books> selectedBooksList = new ArrayList<>();
        try {
            transaction.begin();
            TypedQuery<Books> result =
                    entityManager.createQuery("SELECT books FROM Books books where books.title = '" + title + "'",
                            Books.class);
            transaction.commit();

            selectedBooksList = result.getResultList();

        } catch (Exception exception) {
            transaction.rollback();

        } finally {
            close();
        }

        if (selectedBooksList.isEmpty()) {
            return null;
        } else {
            return selectedBooksList;
        }

    }

    @Override
    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
    }
}
