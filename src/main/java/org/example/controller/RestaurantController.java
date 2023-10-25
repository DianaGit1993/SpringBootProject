package org.example.controller;

import org.example.model.Restaurant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class RestaurantController {

    private final Restaurant restaurant1 = Restaurant.builder()
        .id(1)
        .name("restaurant1")
        .type("type 1")
        .numberOfTables(4)
        .build();
    private final Restaurant restaurant2 = Restaurant.builder()
        .id(2)
        .name("restaurant2")
        .type("type 2")
        .numberOfTables(12)
        .build();

    List<Restaurant> restaurantList = List.of(restaurant1, restaurant2);

    @GetMapping("/restaurant")
    public String getRestaurants(Model model, @RequestParam(required =false) Integer id) {
        if (Objects.isNull(id) || id.equals(0)) {
            model.addAttribute("restaurants", restaurantList);
        } else {
            model.addAttribute("restaurants",
                restaurantList.stream().filter( x-> id == x.getId()).collect(Collectors.toList()));
        }
        return "restaurants";
    }
}
