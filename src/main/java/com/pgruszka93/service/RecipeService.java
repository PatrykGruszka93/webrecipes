package com.pgruszka93.service;

import com.pgruszka93.entity.Comment;
import com.pgruszka93.entity.Recipe;
import com.pgruszka93.model.RecipeModel;

import java.util.Collection;

public interface RecipeService {

    void save(RecipeModel recipeModel);

    Recipe findRecipeById(int recipeId);

    Collection<Recipe> findRecipesByUsername(String userName, int pageNumber);

    void delete(int recipeId);

    int findMaxPageForRecipesList(String userName);

    Collection<Recipe> searchRecipes(String text, int pageNumber);

    int findMaxPageForSearchedRecipes(String text);

    Collection<Comment> findAllRecipeComments(int recipeId);
}
