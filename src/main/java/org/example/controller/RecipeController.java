package org.example.controller;

import org.example.model.Recipe;
import org.example.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController
{
    private final RecipeService reciveService;
    @Autowired
    RecipeController(RecipeService reciveService)
    {
       this.reciveService=reciveService;
    }

    @GetMapping("/getUsersByName")
    public List<Recipe> getUsersByName(@RequestParam String Name)
    {
        return reciveService.fiindUsersByName(Name);
    }

}
