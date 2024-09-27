package ru.gavrilov.CRUD.CRUDspring.dao;

import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gavrilov.CRUD.CRUDspring.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoHibernate implements Userdao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }


    @Transactional
    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    @Transactional
    @Override
    public User findUser(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Transactional
    @Override
    public List<User> findAllUsers() {
        List<User> users = entityManager.createQuery("from User", User.class).getResultList();
        return users;
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }


}

