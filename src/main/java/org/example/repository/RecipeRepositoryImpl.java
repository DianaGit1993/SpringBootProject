package org.example.repository;

import org.example.app.util.RecipeMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.example.model.Recipe;

import java.util.List;

@Repository
public class RecipeRepositoryImpl implements  RecipeRepository {
    private List<Recipe> recipeBook;

    @Autowired
    public RecipeRepositoryImpl(List<Recipe> recipeBook) {
        this.recipeBook = recipeBook;
        this.recipeBook.add(Recipe.builder().name("Eclair")
                .ingredients(List.of("ingredient 1", "ingredient 2", "ingredient 3"))
                .preparationSteps("step 1, step 2 and step 3")
                .cookingTime(12.3)
                .build());
        this.recipeBook.add(Recipe.builder().name("Donut")
                .ingredients(List.of("ingredient 1", "ingredient 2"))
                .preparationSteps("step 1 and step 2")
                .cookingTime(5.0)
                .build());
    }

    // == Public methods ==
    @Override
    public List<Recipe> findRecipeByName(String recipeName) {

        if (recipeBook.isEmpty()
                || recipeName == null
                || recipeName.isEmpty()) return null;

        return (recipeName.equals("*"))
                ? recipeBook
                : recipeBook
                .stream()
                .filter(recipe -> recipe.getName().equalsIgnoreCase(recipeName))
                .toList();
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        if (recipe == null) return false;
        recipeBook.add(recipe);
        return true;
    }

}
