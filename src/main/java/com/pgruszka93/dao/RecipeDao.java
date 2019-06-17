package com.pgruszka93.dao;

import com.pgruszka93.entity.Recipe;

import java.util.Collection;

public interface RecipeDao {

    Collection<Recipe> findNewestRecipes(int pageSize, int pageNumber);

    void save (Recipe recipe);

    Recipe findRecipeById(int recipeId);

    Collection<Recipe> findRecipesByUsername(String userName);

    void delete (int recipeId);


}
