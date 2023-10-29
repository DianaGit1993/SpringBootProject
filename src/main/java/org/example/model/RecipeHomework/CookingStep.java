package org.example.model.RecipeHomework;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class CookingStep {

    private String stepTitle;
    private String stepDescription;
}
