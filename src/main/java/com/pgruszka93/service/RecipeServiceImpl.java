package com.pgruszka93.service;

import com.pgruszka93.dao.RecipeDao;
import com.pgruszka93.dao.UserDao;
import com.pgruszka93.entity.Recipe;
import com.pgruszka93.entity.User;
import com.pgruszka93.model.RecipeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;


@Service
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    private RecipeDao recipeDao;
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void save(RecipeModel recipeModel) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        Recipe theRecipe = new Recipe();
        theRecipe.setTitle(recipeModel.getTitle());
        theRecipe.setHeaderText(recipeModel.getHeaderText());
        theRecipe.setText(recipeModel.getText());
        theRecipe.setDate(new Date());

        User tmpUser = userDao.findByUserName(currentPrincipalName);

        theRecipe.setUser(tmpUser);

        recipeDao.save(theRecipe);
    }

    @Override
    @Transactional
    public Recipe findRecipeById(int recipeId) {
        Recipe theRecipe = recipeDao.findRecipeById(recipeId);
        return theRecipe;
    }

    @Override
    @Transactional
    public Collection<Recipe> findRecipesByUsername(String userName) {
        Collection<Recipe> recipes = recipeDao.findRecipesByUsername(userName);
        return recipes;
    }
}
