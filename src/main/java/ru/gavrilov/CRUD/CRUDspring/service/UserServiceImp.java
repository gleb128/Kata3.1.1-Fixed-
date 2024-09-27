package ru.gavrilov.CRUD.CRUDspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gavrilov.CRUD.CRUDspring.dao.Userdao;
import ru.gavrilov.CRUD.CRUDspring.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private Userdao userdao;

    @Autowired
    public UserServiceImp(Userdao userDao) {
        this.userdao = userDao;
    }

    @Override
    public void saveUser(User user) {
        userdao.saveUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userdao.deleteUser(id);
    }

    @Override
    public User findUser(Long id) {
        return userdao.findUser(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userdao.findAllUsers();
    }

    @Override
    public void updateUser(User user) {
        userdao.updateUser(user);
    }

}


