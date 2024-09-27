package ru.gavrilov.CRUD.CRUDspring.dao;

import ru.gavrilov.CRUD.CRUDspring.model.User;


import java.util.List;

public interface Userdao {

    void saveUser(User user);

    void deleteUser(Long id);

    User findUser(Long id);

    List<User> findAllUsers();

    void updateUser(User user);
}
