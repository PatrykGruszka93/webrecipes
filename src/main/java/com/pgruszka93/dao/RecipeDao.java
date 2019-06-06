package com.pgruszka93.dao;

import com.pgruszka93.entity.Recipe;

import java.util.Collection;

public interface RecipeDao {

    Collection<Recipe> findNewestRecipes(int quantity);

    Collection<Recipe> loadNextRecipes(int quantity);
}
