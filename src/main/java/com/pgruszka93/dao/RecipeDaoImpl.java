package com.pgruszka93.dao;

import com.pgruszka93.entity.Recipe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class RecipeDaoImpl implements RecipeDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Collection<Recipe> findNewestRecipes(int quantity) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("select r from Recipe r join fetch r.user order by r.id DESC");
        query.setMaxResults(quantity);
        Collection <Recipe> recipes = query.list();


        return recipes;
    }


    @Override
    public Collection<Recipe> loadNextRecipes(int quantity){

        Session currentSession = sessionFactory.getCurrentSession();


        //TODO change null
        return null;
    }
}
