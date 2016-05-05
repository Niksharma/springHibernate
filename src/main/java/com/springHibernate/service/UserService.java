package com.springHibernate.service;
 
import java.util.List;

import com.springHibernate.model.User;
 
public interface UserService {
 
    void addUser(User u);
    void updateUser(User u);
    List<User> getUsers();
    User getUser(int id);
    User getUser(String userName, String email);
    void removeUser(int id);
}