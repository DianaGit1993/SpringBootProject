package org.example.controller;

import org.example.model.Recipe;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RecipeController {

    private final Recipe recipe1 = Recipe.builder()
        .name("recipe1")
        .ingredients(new String[]{"ingredient1", "ingredient2"})
        .preparationSteps(new String[]{"step1", "step2"})
        .cookingTime(30)
        .build();
    private final Recipe recipe2 = Recipe.builder()
        .name("recipe2")
        .ingredients(new String[]{"ingredient1", "ingredient2"})
        .preparationSteps(new String[]{"step1", "step2"})
        .cookingTime(60)
        .build();

    List<Recipe> recipeList = List.of(recipe1, recipe2);

    @GetMapping("/recipe")
    public String getRecipes(Model model, @RequestParam(required =false) String name) {
        if (Objects.isNull(name)) {
            model.addAttribute("recipes", recipeList);
        } else {
            model.addAttribute("recipes",
                recipeList.stream().filter( x-> name == x.getName()).collect(Collectors.toList()));
        }
        return "recipes";
    }

}
