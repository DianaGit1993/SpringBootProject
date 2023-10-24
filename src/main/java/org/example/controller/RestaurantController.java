package org.example.controller;

import ch.qos.logback.core.model.Model;
import org.example.model.Restaurant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
public class RestaurantController
{
   private final Restaurant restaurant1=Restaurant.builder()
           .name("Restaurant1")
            .id(1)
            .type("type1")
            .numberOfTable(4)
            .build();
    private final Restaurant restaurant2=Restaurant.builder()
            .name("Restaurant2")
            .id(2)
            .type("type2")
            .numberOfTable(32)
            .build();
    List<Restaurant> restaurantlist=List.of(restaurant1,restaurant2);




}
