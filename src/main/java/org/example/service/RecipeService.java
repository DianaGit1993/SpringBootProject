package org.example.service;
import org.example.model.Recipe;
import org.example.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecipeService
{
    private final RecipeRepository recipeRepository;
    @Autowired
    RecipeService(RecipeRepository recipeRepository)
    {
        this.recipeRepository=recipeRepository;
    }


    public List<Recipe> fiindUsersByName(String Name)
    {
        //validate,transform...
        return recipeRepository.fiindUsersByName(Name)
                .stream()
                .filter(user->user.getName().equals(Name)).toList();
    }
}

