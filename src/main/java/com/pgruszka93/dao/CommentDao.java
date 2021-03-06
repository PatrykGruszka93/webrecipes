package com.pgruszka93.dao;

import com.pgruszka93.entity.Comment;

public interface CommentDao {

    void save(Comment comment);

    void delete(int commentId);

    void deleteAllFromRecipe(int recipeId);

}
