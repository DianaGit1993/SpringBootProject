package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.app.util.AttributeNames;
import org.example.app.util.RecipeMappings;
import org.example.app.util.ViewNames;
import org.example.model.Recipe;
import org.example.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class RecipeController {

    // == Fields ==
    private final RecipeService recipeService;

    // == Constructors ==
    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    // == Request methods ==

//    @RequestMapping({"/",RecipeMappings.RECIPES})

    // This annotation goes together with AppConfig.addViewControllers(ViewControllerRegistry)
    @GetMapping(RecipeMappings.RECIPES)
    public String getRecipeByName(Model model, @RequestParam(required = false) String name) {
        List<Recipe> recipeBook = recipeService.findRecipeByName(name);
        model.addAttribute(AttributeNames.RECIPE_BOOK, recipeBook);
        return ViewNames.RECIPES;
    }

   @GetMapping(RecipeMappings.ADD_RECIPES)
    public String goHome() {
        return ViewNames.ADD_RECIPES;
    }

    @PostMapping(RecipeMappings.ADD_RECIPES)
    public String processMessage(@RequestParam String name, @RequestParam String ingredients,
                                 @RequestParam String preparationSteps, @RequestParam String cookingTime) {
        log.info("name = {}, ingredients = {}, preparationSteps = {}, cookingTime = {}",
                name, ingredients, preparationSteps, cookingTime);

        log.info("Recipe added = {}",
                recipeService.addRecipe(name, ingredients, preparationSteps, cookingTime));

        return RecipeMappings.REDIRECT_ADD_RECIPES;
    }

}
