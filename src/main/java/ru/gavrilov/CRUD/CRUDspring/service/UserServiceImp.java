package ru.gavrilov.CRUD.CRUDspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    @Override
    public void saveUser(User user) {
        userdao.saveUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userdao.deleteUser(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User findUser(Long id) {
        return userdao.findUser(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAllUsers() {
        return userdao.findAllUsers();
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userdao.updateUser(user);
    }

}


