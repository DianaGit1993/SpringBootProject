package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Recipe
{
    private String name;
    private String ingredients;
    private String preparationSteps;
    private String cookingTime;

}
