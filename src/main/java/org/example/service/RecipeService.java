package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.models.Recipe;
import org.example.repository.RecipeRepositoryImpl;

import java.util.List;
import java.util.stream.Stream;

@Service
public class RecipeService {

    // == Fields ==
    private final RecipeRepositoryImpl recipeRepository;

    // == Constructors ==
    @Autowired
    public RecipeService(RecipeRepositoryImpl recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    // == Public methods ==

    public List<Recipe> findRecipeByName(String recipeName) {
        return recipeRepository.findRecipeByName(recipeName);
    }


    public boolean addRecipe(String name, String ingredients,
                             String preparationSteps, String cookingTime) {

        if (isInvalidString(name)
                || isInvalidString(ingredients)
                || isInvalidString(preparationSteps)
                || isInvalidString(cookingTime)) return false;

        // Validate input parameters and then call recipeRepository.add()
        Recipe recipe = Recipe.builder()
                .name(name)
                .ingredients(stringToStringList(ingredients))
                .preparationSteps(preparationSteps)
                .cookingTime(Double.parseDouble(cookingTime))
                .build();

        return recipeRepository.addRecipe(recipe);
    }

    public boolean isInvalidString(String value) {
        return (value == null) || value.isEmpty();
    }

    public List<String> stringToStringList(String value) {
        if (isInvalidString(value)) return null;
        return Stream.of(value.trim().split("\\n")).map(String::trim).toList();
    }
}
