package edu.domgie.sda.interfaces;

public class InterfaceDemo {
    public static void main(String[] args) {
        User user = new User("GTA");
        user.playGame();
        user.code("c#");
        Coding coder = new User("GTA3");
        coder.code("Java");
        ((User)coder).playGame();


    }
}

