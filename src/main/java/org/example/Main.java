package org.example;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        User user = new User(2,"Jhon");
        user.getId();
        user.setId(2);

        User user2 = User.builder().id(2).name("Jhon").build();
        //test2
    }
}