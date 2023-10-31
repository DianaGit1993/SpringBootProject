package org.example.app.util;

import org.example.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("recipeMappings")
public final class RecipeMappings {

    // == Constants ==
    public static final String RECIPES = "/" + ViewNames.RECIPES;  //getRecipeByName";
    public static final String ADD_RECIPES = "/" + ViewNames.ADD_RECIPES; //"addRecipe";
    public static final String REDIRECT_ADD_RECIPES = "redirect:" + ADD_RECIPES;
    public static final String HOME = "/";

    // == Private Constructor ==
    private RecipeMappings() {}

}
