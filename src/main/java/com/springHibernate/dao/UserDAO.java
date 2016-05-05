package com.springHibernate.dao;
 
import java.util.List;
 
import com.springHibernate.model.User;
 
public interface UserDAO {
    void addUser(User u);
    void updateUser(User u);
    List<User> getUsers();
    User findUserById(int id);
    User findUserByNameAndEmail(String userName, String email);
    void deleteUser(int id);
}