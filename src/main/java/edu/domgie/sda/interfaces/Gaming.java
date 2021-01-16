package edu.domgie.sda.interfaces;

public interface Gaming {
    void playGame();

    default boolean isWinner(int points) {
        return true;
    }
}
