package com.springHibernate.dao.impl;
 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.springHibernate.dao.UserDAO;
import com.springHibernate.model.User;
 
@Repository
public class UserDAOImpl implements UserDAO {
     
    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public void addUser(User u) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(u);
        logger.info("User saved successfully, User Details="+u);
    }
 
    @Override
    public void updateUser(User u) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(u);
        logger.info("User updated successfully, User Details="+u);
    }
 
    @Override
    public List<User> getUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> usersList = session.createQuery("from User").list();
        for(User u : usersList){
            logger.info("User List::"+u);
        }
        return usersList;
    }
 
    @Override
    public User findUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        User u = (User) session.load(User.class, new Integer(id));
        logger.info("User loaded successfully, User details="+u);
        return u;
    }
    
    @Override
    public User findUserByNameAndEmail(String userName, String email) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where userName = :userName and email = :email");
        query.setParameter("userName", userName);
        query.setParameter("email", email);
        List<User> usersList = query.list();
        User u = null;
        if (usersList != null && usersList.size() > 0) {
        	u = usersList.get(0);
		}
        logger.info("User loaded successfully, User details="+u);
        return u;
    }
 
    @Override
    public void deleteUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User u = (User) session.load(User.class, new Integer(id));
        if(null != u){
            session.delete(u);
        }
        logger.info("User deleted successfully, User details="+u);
    }
 
}