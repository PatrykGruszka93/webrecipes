package com.pgruszka93.dao;

import com.pgruszka93.entity.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDaoImpl implements CommentDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Comment comment) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(comment);


    }
}
