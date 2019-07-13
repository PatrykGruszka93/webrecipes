package com.pgruszka93.service;

import com.pgruszka93.model.CommentModel;

public interface CommentService {

    void save(CommentModel commentModel, int recipeId);

    void delete(int commentId);

    void deleteAllFromRecipe(int recipeId);
}
