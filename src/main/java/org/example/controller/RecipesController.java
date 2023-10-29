package org.example.controller;

import org.example.model.RecipeHomework.CookingStep;
import org.example.model.RecipeHomework.Nutrition;
import org.example.model.RecipeHomework.Recipe;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class RecipesController {

    @GetMapping("/recipes")
    public String getRestaurants(Model model, @RequestParam(required = false) String category){


        if(Objects.isNull(category) || category.equals("all")){
            model.addAttribute("recipes",recipeList);
            model.addAttribute("currentCategory","all");
        }else{
            model.addAttribute("currentCategory",category);
            model.addAttribute("recipes", recipeList.stream().filter(x->category.equals(x.getCategory())).collect(Collectors.toList()));

        }

        model.addAttribute("categories",categories);

        return "recipes";
    }

    @GetMapping("/recipes/{recipe}")
    public String getRecipe(Model model, @PathVariable String recipe){

        if(Objects.isNull(recipe) ){
            return "recipes";
        }else{
            for(Recipe r: recipeList){
                if(r.getTitle().equalsIgnoreCase(recipe)){

                    model.addAttribute("recipe",r);
                }
            }

        }


        return "recipe";
    }





    private final Recipe recipe1=Recipe.builder()
            .title("Sheet Pan Fried Eggs")
            .imageUrl("/images/Simply-Recipes-Sheet-Pan-Fried-Eggs.png")
            .category("breakfast")
            .shortDescription("Making breakfast or brunch for a crowd? Pull out a sheet pan! It's the easiest way to make a bunch of fried eggs at once." )
            .recipeAuthor("Sarah Epperson")
            .uploadDate(LocalDate.of(2023, Month.JUNE,5))
            .prepTime("20 mins")
            .cookingTime("5 mins")
            .totalTime("25 mins")
            .ingredients(
                    List.of(
                            "10 large eggs",
                            "Olive oil",
                            "1/4 teaspoon salt and pepper"
                    )
            )
            .cookingMethodSteps(

                    List.of(
                            CookingStep.builder()
                                    .stepTitle("Preheat the sheet pan in the oven")
                                    .stepDescription("Arrange a rack in the middle of oven and place a rimmed baking sheet on the middle rack. Preheat oven to 425°F, letting the sheet pan preheat in the oven for 15 minutes.")
                                    .build(),
                            CookingStep.builder()
                                    .stepTitle("Prepare the eggs and oil the sheet pan")
                                    .stepDescription("Meanwhile, crack the eggs in a liquid measuring cup. " +
                                            "Once the sheet pan is preheated, remove it from the oven. Working quickly, drizzle olive oil " +
                                            "onto the hot sheet pan, coating it generously to prevent sticking.")
                                    .build(),
                            CookingStep.builder()
                                    .stepTitle("Bake and serve")
                                    .stepDescription("Pour the eggs, 1 at a time, beside each other onto the sheet pan (careful not to crack yolks).\n" +
                                            "\n" +
                                            "Return the sheet pan to the oven and bake until the egg whites are set but the yolks are still jiggly," +
                                            " about 5 minutes, or until desired doneness. Sprinkle with salt and pepper, and serve.")
                                    .build()

                    )



            )
            .nutrition(
                    Nutrition.builder()
                            .calories("84")
                            .fat("6g")
                            .carbs("0g")
                            .protein("6g")
                            .build()
            )
            .build();


    private final Recipe recipe2=Recipe.builder()
            .title("Air Fryer Baked Potatoes")
            .imageUrl("/images/Simply-Recipes-Air-Fryer-Baked-Potatoes.png")
            .category("lunch")
            .shortDescription("For a baked potato with the crispiest skin and a light and fluffy interior, don’t turn on the oven. Use the air fryer instead!" )
            .recipeAuthor("Kayla Hoang")
            .uploadDate(LocalDate.of(2023, Month.JULY,13))
            .prepTime("3 mins")
            .cookingTime("40 mins")
            .totalTime("43 mins")
            .servings("4 servings")
            .ingredients(
                    List.of(
                            "4 medium to medium-large russet potatoes (about 10 ounces each)",
                            "1 tablespoon olive oil, divided ",
                            "1/2 teaspoon kosher salt, divided, plus more for serving",
                            "Freshly ground black pepper, unsalted butter, shredded sharp cheddar, sour cream, and/or scallions, for serving (as desired)"
                    )
            )
            .cookingMethodSteps(
                    List.of(
                            CookingStep.builder()
                                    .stepTitle("Prepare the air fryer and potatoes")
                                    .stepDescription("Preheat the air fryer to 390°F if your air fryer requires preheating. If your air fryer has multiple settings, use the “air fry” setting. \n" +
                                            "\n" +
                                            "Wash and scrub the potatoes and pat them dry with a towel.\n" +
                                            "\n" +
                                            "Poke each potato all around about 16 times with a fork. Rub each potato with 3/4 teaspoon olive oil and 1/8 teaspoon kosher salt.")
                                    .build(),
                            CookingStep.builder()
                                    .stepTitle("Air fry the potatoes")
                                    .stepDescription("Place the potatoes into the basket of the air fryer, leaving about 1 inch between each potato.\n" +
                                            "\n" +
                                            "Return the basket to the fryer and cook at 390°F until the potatoes are fork tender and the skin is golden brown and crisp, 40 to 50 minutes, flipping each potato halfway through cooking.")
                                    .build(),
                            CookingStep.builder()
                                    .stepTitle("Serve")
                                    .stepDescription("Serve:\n" +
                                            "Remove the potatoes from the air fryer with a pair of tongs. Using a sharp knife, slice each potato through the top lengthwise (without cutting all the way through) to reveal the steamy interior. \n" +
                                            "\n" +
                                            "Use a fork to fluff the insides of the potato. Season and top as desired with more salt, freshly ground black pepper, unsalted butter, shredded sharp cheddar, sour cream, and/or scallions. Serve immediately while the insides are still hot and the skin is still crispy. \n" +
                                            "\n" +
                                            "The potatoes can be stored in an airtight container in the refrigerator for up to 3 days. ")
                                    .build()
                    )
            )
            .nutrition(
                    Nutrition.builder()
                            .calories("305")
                            .fat("4g")
                            .carbs("61g")
                            .protein("7g")
                            .build()
            )
            .build();


    private final Recipe recipe3=Recipe.builder()
            .title("Buffalo Chicken Tacos")
            .imageUrl("/images/Simply-Recipes-Buffalo-Chicken-Tacos.png")
            .category("dinner")
            .shortDescription("This weeknight winner is ready in under 20 minutes and is topped with a creamy, crunchy slaw and blue cheese." )
            .recipeAuthor("Sheela Prakash")
            .uploadDate(LocalDate.of(2023, Month.OCTOBER,4))
            .prepTime("15 mins")
            .cookingTime("2 mins")
            .totalTime("17 mins")
            .servings("4 to 6 servings")
            .ingredients(
                    List.of(
                            "6 tablespoons (3/4 stick) unsalted butter",
                            "1/2 cup hot sauce, such as Franks RedHot or Cholula",
                            "1/2 teaspoon garlic powder",
                            "1 small or 1/2 large plain rotisserie chicken (about 1 3/4 pounds), shredded (about 4 packed cups)",
                            "3 tablespoons whole milk plain Greek yogurt or sour cream",
                            "2 tablespoons freshly squeezed lime juice (about 1 medium lime)",
                            "1 tablespoon olive oil",
                            "1/2 teaspoon kosher salt",
                            "1/4 teaspoon freshly ground black pepper",
                            "4 packed cups (10 ounces) coleslaw mix",
                            "12 (6-inch) flour tortillas",
                            "2 green onions, thinly sliced",
                            "4 ounces blue cheese, crumbled (about 1 cup)"
                    )
            )

            .cookingMethodSteps(
                    List.of(
                            CookingStep.builder()
                                    .stepTitle("Make the Buffalo chicken")
                                    .stepDescription("Microwave the butter in a large microwave-safe bowl in 4 to 6 (10-second) bursts until just melted. Add the hot sauce and garlic powder and whisk until combined. Add the shredded chicken and toss to coat. \n" +
                                            "\n" +
                                            "Alternatively, melt the butter in a small saucepan over medium-low heat. Turn off the heat and add the hot sauce and garlic powder, then transfer to a large bowl and combine with the chicken.")
                                    .build(),
                            CookingStep.builder()
                                    .stepTitle("Make the coleslaw")
                                    .stepDescription("Place the Greek yogurt or sour cream, lime juice, olive oil, salt, and pepper in a large bowl and whisk to combine. Add the coleslaw mix and toss to coat.")
                                    .build(),
                            CookingStep.builder()
                                    .stepTitle("Warm the tortillas")
                                    .stepDescription("Stack the tortillas on a microwave-safe plate and cover with a damp paper towel. Microwave until warm, 30 to 45 seconds. Wrap the stack in a clean kitchen towel or aluminum foil to keep warm until ready to use.")
                                    .build(),
                            CookingStep.builder()
                                    .stepTitle("Assemble the tacos:")
                                    .stepDescription("To assemble the tacos, top the warmed tortillas with coleslaw. Top with the buffalo chicken and garnish with the scallions and blue cheese.")
                                    .build()
                    )
            )
            .nutrition(
                    Nutrition.builder()
                            .calories("753")
                            .fat("48g")
                            .carbs("46g")
                            .protein("34g")
                            .build()
            )
            .build();


    private final Recipe recipe4=Recipe.builder()
            .title("Boozy Hot Chocolate")
            .imageUrl("/images/Simply-Recipes-Boozy-Hot-Chocolate.png")
            .category("drinks")
            .shortDescription("This adults-only boozy hot chocolate is rich, creamy, and very decadent. With endless varieties of add-ins, you’ll never get tired of trying this chocolatey recipe." )
            .recipeAuthor("Elana Lepkowski")
            .uploadDate(LocalDate.of(2022, Month.OCTOBER,12))
            .prepTime("10 mins")
            .cookingTime("5 mins")
            .totalTime("15 mins")
            .servings("2 servings")
            .ingredients(
                    List.of(
                            "2 cups whole milk",
                            "6 ounces semisweet chocolate, finely chopped",
                            "3 ounces liquor of choice, such as bourbon, rum, or a cream liqueur",
                            "1/2 teaspoon vanilla extract",
                            "1 pinch kosher salt",
                            "Optional toppings: mini marshmallows or whipped cream, chocolate shavings, sprinkles"
                    )
            )

            .cookingMethodSteps(
                    List.of(
                            CookingStep.builder()
                                    .stepTitle("Warm the milk")
                                    .stepDescription("Warm the milk in a medium saucepan over medium-low heat until it begins to barely simmer but not boil (watch for small bubbles around the edges).")
                                    .build(),
                            CookingStep.builder()
                                    .stepTitle("Add the chocolate")
                                    .stepDescription("Add in the chopped chocolate and whisk until combined and smooth, about 5 minutes. There should be no remaining specks of chocolate, the color should turn from a pale tan to a milk chocolatey brown, and the bottom of your pan should be coated with the mixture.")
                                    .build(),
                            CookingStep.builder()
                                    .stepTitle("Remove from the heat and add the remaining ingredients")
                                    .stepDescription("Remove from the heat and stir in the liquor, vanilla extract, and salt.")
                                    .build(),
                            CookingStep.builder()
                                    .stepTitle("Cool slightly and serve")
                                    .stepDescription("Let sit to cool to a safe drinking temperature for about 5 minutes (still hot but not burning). Pour into heatproof mugs. If a skin forms while cooling, just whisk it for a few seconds to reincorporate.\n" +
                                            "\n" +
                                            "Enjoy as-is or topped with desired toppings.")
                                    .build()
                    )
            )
            .nutrition(
                    Nutrition.builder()
                            .calories("721")
                            .fat("34g")
                            .carbs("83g")
                            .protein("11g")
                            .build()
            )
            .build();

    private final Recipe recipe5=Recipe.builder()
            .title("Grilled Banana Split")
            .imageUrl("/images/Simply-Recipes-Grilled-Banana-Split.png")
            .category("dessert")
            .shortDescription("A few minutes on the grill transforms this classic dessert." )
            .recipeAuthor("Frank Tiu")
            .uploadDate(LocalDate.of(2023, Month.JUNE,24))
            .prepTime("15 mins")
            .cookingTime("10 mins")
            .totalTime("25 mins")
            .servings("4 to 8 servings")
            .ingredients(
                    List.of(
                            "4 slightly underripe bananas, unpeeled",
                            "12 large strawberries",
                            "1/2 medium pineapple, peeled and cored",
                            "2 teaspoons vegetable oil",
                            "1 teaspoon cinnamon, optional",
                            "4 scoops vanilla ice cream (about 1 pint)",
                            "4 scoops strawberry ice cream (about 1 pint)",
                            "4 scoops chocolate ice cream (about 1 pint)",
                            "Optional toppings: Chocolate sauce, Whipped cream, 2 tablespoons dry roasted peanuts, chopped, 12 maraschino cherries with stems"
                    )
            )

            .cookingMethodSteps(
                    List.of(
                            CookingStep.builder()
                                    .stepTitle("Preheat the grill")
                                    .stepDescription("Preheat the grill to high heat, about 450°F. If needed, clean the grates.")
                                    .build(),
                            CookingStep.builder()
                                    .stepTitle("Prep the fruit")
                                    .stepDescription("Don’t peel the bananas. Use a sharp knife to slice them lengthwise, peel and all, going through the stem. \n" +
                                            "\n" +
                                            "Slice the strawberries in half lengthwise. Line up halved berries on a cutting board and slide a skewer through the center, leaving about 2 inches of the skewer uncovered on each end to make them easy to handle. Repeating with the remaining berries. \n" +
                                            "\n" +
                                            "Cut the pineapple into 4-inch long spears that are roughly 1 1/2 inches wide. Brush the cut sides of the bananas and strawberries with a light layer of oil. Brush all sides of the pineapple with oil.")
                                    .build(),
                            CookingStep.builder()
                                    .stepTitle("Grill the fruit")
                                    .stepDescription("Wet a folded clean paper towel with oil and grasp it with tongs. Use it to carefully oil the hot grates.\n" +
                                            "\n" +
                                            "Add the fruit to the grill with the strawberries and bananas cut side down. Cook just until grill marks form, 1 to 2 minutes. Remove the strawberries and bananas from the grill and flip the pineapple, grilling on all 4 sides for 1 to 2 minutes per side.")
                                    .build(),
                            CookingStep.builder()
                                    .stepTitle("Let cool and chop")
                                    .stepDescription("Let the fruit cool for 5 minutes. Peel the grilled bananas and lightly dust with cinnamon (if using). Dice the strawberries and pineapple.")
                                    .build(),
                            CookingStep.builder()
                                    .stepTitle("Assemble the banana splits")
                                    .stepDescription("Place the grilled bananas along the sides of the dishes or bowls. Add a scoop of vanilla, strawberry, and chocolate ice cream to each. Top the vanilla with diced grilled pineapple, top the strawberry ice cream with the grilled diced strawberries, and top the chocolate ice cream with chocolate sauce. \n" +
                                            "\n" +
                                            "Top with whipped cream, peanuts, and maraschino cherries, if using. Add an extra drizzle of chocolate sauce, if desired. Serve immediately. ")
                                    .build()
                    )
            )
            .nutrition(
                    Nutrition.builder()
                            .calories("283")
                            .fat("11g")
                            .carbs("44g")
                            .protein("4g")
                            .build()
            )
            .build();

    private final Recipe recipe6=Recipe.builder()
            .title("Taco Salad")
            .imageUrl("/images/SimplyRecipesTacoSaladLead.png")
            .category("dinner")
            .shortDescription("Build a better taco salad, right at home." )
            .recipeAuthor("Stephanie Burt")
            .uploadDate(LocalDate.of(2023, Month.JUNE,5))
            .prepTime("15 mins")
            .cookingTime("20 mins")
            .totalTime("35 mins")
            .servings("4 servings")
            .ingredients(
                    List.of(
                            "1 pound ground beef, 85/15 (ground turkey or crumbled tofu work equally well too)",
                            "1 teaspoon olive oil",
                            "2 tablespoons taco seasoning (from one 1-ounce package)",
                            "2/3 cup water",
                            "5 loosely packed cups chopped romaine lettuce (approximately 1 heart of romaine) ",
                            "1 cup finely shredded Mexican blend cheese, or the cheese of your choice",
                            "4 green onions, chopped",
                            "1 1/2 cups cherry or grape tomatoes, halved",
                            "1 (2.25-ounce) can sliced black olives, drained",
                            "8 tostadas, lightly crushed",
                            "4 tablespoons full fat sour cream",
                            "1/2 cup salsa of your choice",
                            "1 lime, quartered"
                    )
            )

            .cookingMethodSteps(
                    List.of(
                            CookingStep.builder()
                                    .stepTitle("Brown the meat")
                                    .stepDescription("Place a medium skillet over medium-high heat. Add olive oil then beef into the pan. As the meat browns, intermittently use a spatula or wooden spoon to break it up but do not constantly do so or it will be too fine (uneven sizes will help the taco seasoning to adhere better).")
                                    .build(),
                            CookingStep.builder()
                                    .stepTitle("Prep the salad ingredients")
                                    .stepDescription("While the meat is browning, take the time to prep all the remaining ingredients. Part of the joy of this taco salad isn’t just the taste–it’s the fact that it can get to the table in 30 minutes, start to finish–and using this time wisely means that when the meat is cooked, you’ll be ready to assemble.")
                                    .build(),
                            CookingStep.builder()
                                    .stepTitle("Sauce the meat")
                                    .stepDescription("Once the ground beef has fully browned, turn the heat to medium and sprinkle the taco seasoning over it. Stir to coat meat, and then pour the water in the pan, stirring again to make sure there are no dry spots or clumps of seasoning. Then allow the meat to simmer and the sauce to reduce, stirring occasionally, until the meat is just damp but not soggy, about 5-8 minutes.")
                                    .build(),
                            CookingStep.builder()
                                    .stepTitle("Assemble the salads")
                                    .stepDescription("Remove beef from the heat and set aside but keep warm. Do not drain.\n" +
                                            "\n" +
                                            "Pasta bowls are ideal for these main dish salads, but any big plate or bowl will work.\n" +
                                            "\n" +
                                            "For each serving, layer as follows: 1 crushed tostada, 1 cup loosely packed lettuce, 1/2 cup meat, 1/4 cup shredded cheese, 1/3 cup tomatoes, sprinkle of chopped green onion, 2 tablespoons olives, and 1 more lightly crushed tostada. Garnish with 1 tablespoon sour cream and 2 tablespoons salsa. Serve with lime wedges on the side for squeezing.")
                                    .build()
                    )
            )
            .nutrition(
                    Nutrition.builder()
                            .calories("623")
                            .fat("38g")
                            .carbs("33g")
                            .protein("38g")
                            .build()
            )
            .build();


    List<Recipe> recipeList=List.of(recipe1,recipe2,recipe3,recipe4,recipe5,recipe6);
    List<String> categories=List.of("all","breakfast","lunch","dinner","dessert","drinks");



}
