package com.pgruszka93.service;

import com.pgruszka93.entity.Recipe;
import com.pgruszka93.model.RecipeModel;

import java.util.Collection;

public interface RecipeService {

    void save(RecipeModel recipeModel);

    Recipe findRecipeById(int recipeId);

    Collection<Recipe> findRecipesByUsername(String userName);

    void delete(int recipeId);

}
