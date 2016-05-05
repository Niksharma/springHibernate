package com.springHibernate.service.impl;
 
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springHibernate.dao.UserDAO;
import com.springHibernate.model.User;
import com.springHibernate.service.UserService;
 
@Service
public class UserServiceImpl implements UserService {
     
    private UserDAO userDAO;
 
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
 
    @Override
    @Transactional
    public void addUser(User u) {
        this.userDAO.addUser(u);
    }
 
    @Override
    @Transactional
    public void updateUser(User u) {
        this.userDAO.updateUser(u);
    }
 
    @Override
    @Transactional
    public List<User> getUsers() {
        return this.userDAO.getUsers();
    }
 
    @Override
    @Transactional
    public User getUser(int id) {
        return this.userDAO.findUserById(id);
    }
    
    @Override
    @Transactional
    public User getUser(String userName, String email) {
        return this.userDAO.findUserByNameAndEmail(userName, email);
    }
 
    @Override
    @Transactional
    public void removeUser(int id) {
        this.userDAO.deleteUser(id);
    }
 
}