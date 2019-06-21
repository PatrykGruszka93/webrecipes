package com.pgruszka93.service;

import com.pgruszka93.dao.CommentDao;
import com.pgruszka93.dao.RecipeDao;
import com.pgruszka93.dao.UserDao;
import com.pgruszka93.entity.Comment;
import com.pgruszka93.entity.Recipe;
import com.pgruszka93.entity.User;
import com.pgruszka93.model.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentDao commentDao;

    @Autowired
    UserDao userDao;

    @Autowired
    RecipeDao recipeDao;

    @Override
    @Transactional
    public void save(CommentModel commentModel, int recipeId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User tmpUser = userDao.findByUserName(currentPrincipalName);
        Recipe tmpRecipe = recipeDao.findRecipeById(recipeId);

        Comment theComment= new Comment();
        if(commentModel.getId()!=0){
            theComment.setId(commentModel.getId());
        }

        theComment.setText(commentModel.getText());
        theComment.setDate(new Date());
        theComment.setUser(tmpUser);
        theComment.setRecipe(tmpRecipe);

        commentDao.save(theComment);
    }
}
