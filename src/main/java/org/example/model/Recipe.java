package org.example.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Recipe {
    private String name;
    private String[] ingredients;
    private String[] preparationSteps;
    private int cookingTime;
}
