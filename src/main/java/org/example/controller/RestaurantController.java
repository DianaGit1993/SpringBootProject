package org.example.controller;

import org.example.model.Restaurant;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RestaurantController {

    private final Restaurant restaurant1= Restaurant.builder()
            .id(1)
            .name("restaurant 1")
            .type("type 1")
            .numberOfTables(4)
            .build();

    private final Restaurant restaurant2= Restaurant.builder()
            .id(2)
            .name("restaurant 2")
            .type("type 2")
            .numberOfTables(12)
            .build();

    List<Restaurant> restaurantList = List.of(restaurant1, restaurant2);



}
