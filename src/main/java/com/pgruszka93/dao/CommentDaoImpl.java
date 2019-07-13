package com.pgruszka93.dao;

import com.pgruszka93.entity.Comment;
import com.pgruszka93.entity.Recipe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class CommentDaoImpl implements CommentDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Comment comment) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(comment);


    }

    @Override
    public void delete(int commentId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Comment> query = currentSession.createQuery("delete from Comment c where c.id=:commentId");
        query.setParameter("commentId", commentId);

        query.executeUpdate();

    }


    @Override
    public void deleteAllFromRecipe(int recipeId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Recipe> query = currentSession.createQuery("select r from Recipe r join fetch r.user where r.id=:theId", Recipe.class);
        query.setParameter("theId", recipeId);
        Recipe theRecipe = null;
        try {
            theRecipe = query.getSingleResult();
        } catch (Exception e) {
            theRecipe = null;
        }

        Collection<Comment> theComments = theRecipe.getComments();

        for(Comment tempComment : theComments){
            delete(tempComment.getId());
        }

    }
}
