package ru.gavrilov.CRUD.CRUDspring.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.gavrilov.CRUD.CRUDspring.model.User;

import java.util.List;


@Repository
public class UserDaoHibernate implements Userdao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }


    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }


    @Override
    public User findUser(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }


    @Override
    public List<User> findAllUsers() {
        List<User> users = entityManager.createQuery("from User", User.class).getResultList();
        return users;
    }


    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }


}

