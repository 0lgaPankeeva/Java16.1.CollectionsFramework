package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }

    public ArrayList register(Player player) {
        players.add(player);
        return (ArrayList) players;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(
                    "Игрок не зарегистрирован:   " + playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    "Игрок не зарегистрирован:   " + playerName2);
        }
        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        return 2;
    }

}