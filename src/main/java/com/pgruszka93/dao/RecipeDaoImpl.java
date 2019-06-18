package com.pgruszka93.dao;

import com.pgruszka93.entity.Recipe;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class RecipeDaoImpl implements RecipeDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Collection<Recipe> findNewestRecipes(int pageSize, int pageNumber) {


        Session currentSession = sessionFactory.getCurrentSession();


        Query query = currentSession.createQuery("select r from Recipe r join fetch r.user order by r.id DESC");
        query.setFirstResult(pageSize*(pageNumber-1));
        query.setMaxResults(pageSize);

        Collection <Recipe> recipes = query.list();

        return recipes;
    }

    @Override
    public void save (Recipe recipe){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(recipe);
    }

    @Override
    public Recipe findRecipeById(int recipeId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Recipe> query = currentSession.createQuery("select r from Recipe r join fetch r.user where r.id=:theId", Recipe.class);
        query.setParameter("theId", recipeId);

        Recipe theRecipe = null;

        try {
            theRecipe = query.getSingleResult();
        } catch (Exception e) {
            theRecipe = null;
        }

        return theRecipe;
    }

    @Override
    public Collection<Recipe> findRecipesByUsername(String userName, int pageSize, int pageNumber) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("select r from Recipe r join fetch r.user where r.user.userName=:theUserName order by r.id DESC");

        query.setParameter("theUserName", userName);

        query.setFirstResult(pageSize*(pageNumber-1));
        query.setMaxResults(pageSize);

        Collection <Recipe> recipes = query.list();


        return recipes;
    }

    @Override
    public void delete(int recipeId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("delete from Recipe r where r.id=:recipeId");

        query.setParameter("recipeId", recipeId);

        query.executeUpdate();
    }

    @Override
    public Long countUsersRecipes(String userName) {

        Session currentSession = sessionFactory.getCurrentSession();
                Query query = currentSession.createQuery( "Select count (r.id) from Recipe r join r.user where r.user.userName=:theUserName");
        query.setParameter("theUserName", userName);
        Long countResults = (Long) query.uniqueResult();
        return countResults;
    }
}
