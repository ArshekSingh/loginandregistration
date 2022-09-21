package com.example.loginandregistration.repository;

import com.example.loginandregistration.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.websocket.Session;

@Repository
public class UserDaoImpl {

    @Autowired
    private EntityManager em;

//    public User save(User user) {
//        Session session = em.unwrap(Session.class);
//        session.persist(user);
//        return user;
//    }
}
