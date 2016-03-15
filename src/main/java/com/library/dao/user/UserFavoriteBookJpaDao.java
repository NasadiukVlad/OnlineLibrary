package com.library.dao.user;

import com.library.domain.book.Books;
import com.library.domain.user.UserFavoriteBooks;
import com.library.domain.user.Users;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 15.03.2016.
 */
public class UserFavoriteBookJpaDao implements UserFavoriteBookDao {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public UserFavoriteBookJpaDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("OnlineLibraryPersistance");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    @Override
    public void addFavoriteBook(UserFavoriteBooks userFavoriteBooks) {
        try {
            transaction.begin();
            entityManager.persist(userFavoriteBooks);
            transaction.commit();

        } catch (Exception exception) {
            transaction.rollback();

        } finally {
            close();
        }
    }

    @Override
    public List<UserFavoriteBooks> getByUser(String username) {
        List<UserFavoriteBooks> selectedBooksList = new ArrayList<>();
        try {
            transaction.begin();

            /*TypedQuery<UserFavoriteBooks> favoriteBooksResult =
                    entityManager.createQuery("SELECT userFavoriteBooks FROM UserFavoriteBooks userFavoriteBooks where userFavoriteBooks.username = '" + username + "'",
                            UserFavoriteBooks.class);*/
            TypedQuery<UserFavoriteBooks> favoriteBooksResult =
                    entityManager.createQuery("SELECT userfavoritebooks FROM UserFavoriteBooks userfavoritebooks where userfavoritebooks.username = '" + username + "'",
                            UserFavoriteBooks.class);
            transaction.commit();

            selectedBooksList = favoriteBooksResult.getResultList();

        } catch (Exception exception) {
            transaction.rollback();

        } finally {
            close();
        }

        return selectedBooksList;


    }

    @Override
    public List<UserFavoriteBooks> getAll() {
        List<UserFavoriteBooks> allUsersList = new ArrayList<>();

        try {
            transaction.begin();
            TypedQuery<UserFavoriteBooks> allUsersQueryResult =
                    entityManager.createQuery("SELECT userFavoriteBooks FROM UserFavoriteBooks userFavoriteBooks", UserFavoriteBooks.class);
            transaction.commit();

            allUsersList = allUsersQueryResult.getResultList();

        } catch (Exception exception) {
            transaction.rollback();

        } finally {
            close();
        }

        return allUsersList;
    }

    @Override
    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
    }
}
