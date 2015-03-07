package com.example.app;

/**
 * Created by Casey on 1/17/2015.
 */
public class Player {
    String firstName;
    String lastName;
    int playerNumber;
    String playerPosition;
    Team TeamObject;
    String teamName;
    PlayerStats playerStats;
    int playerId;

    public Player(String firstNm, String lastNm) {
        firstName = firstNm;
        lastName = lastNm;

    }
}
