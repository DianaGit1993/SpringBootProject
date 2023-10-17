package session26.practice;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Users user = new Users(2,"John");
        user.getId();
        user.setId(2);

        Users user2 = Users.builder().id(2).name("John").build();
    }
}