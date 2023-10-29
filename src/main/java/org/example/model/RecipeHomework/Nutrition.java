package org.example.model.RecipeHomework;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@EqualsAndHashCode
@ToString

public class Nutrition {

    private String calories;
    private String fat;
    private String carbs;
    private String protein;
}
