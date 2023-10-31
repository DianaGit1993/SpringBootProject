package org.example.repository;

import org.example.models.Recipe;

import java.util.List;

public interface RecipeRepository {

    List<Recipe> findRecipeByName(String recipeName);
    boolean addRecipe(Recipe recipe);
}
