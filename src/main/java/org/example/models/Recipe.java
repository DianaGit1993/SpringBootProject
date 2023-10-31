package org.example.models;

import lombok.*;

import java.util.List;

@Getter
@Builder
@ToString
public class Recipe {
    private String name;
    private List<String> ingredients;
    private String preparationSteps;
    private Double cookingTime;
}
