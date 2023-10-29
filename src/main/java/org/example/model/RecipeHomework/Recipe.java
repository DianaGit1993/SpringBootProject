package org.example.model.RecipeHomework;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Recipe {

    private String imageUrl; //image for recipe
    private String title;     //title of recipe

    private String category;  //category of recipe; e.g. breakfast, lunch..
    private String shortDescription;
    private String recipeAuthor;
    private LocalDate uploadDate;
    private String totalTime;      // total time for recipe
    private String prepTime;
    private String cookingTime;
    private String servings;
    private List<String> ingredients;
    private List<CookingStep> cookingMethodSteps;
    private Nutrition nutrition;
}
