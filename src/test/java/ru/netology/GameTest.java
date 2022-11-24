package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    Game game = new Game();
    Player[] player = new Player[0];

    Player player1 = new Player(1, "Игрок1", 15_000);
    Player player2 = new Player(2, "Игрок2", 33_000);
    Player player3 = new Player(3, "Игрок3", 9_000);
    Player player4 = new Player(4, "Игрок4", 33_000);

    @Test

    public void shouldRegisteredPlayer() {


        List<Player> expected = new ArrayList<>();

        expected.add(player3);

        ArrayList actual = game.register(player3);

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldChooseWinnerFirst() {

        List<Player> players = new ArrayList<>();
        game.register(player1);
        game.register(player3);


        int expected = 1;

        int actual = game.round("Игрок1", "Игрок3");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldChooseWinnerSecond() {

        List<Player> players = new ArrayList<>();
        game.register(player1);
        game.register(player2);


        int expected = 2;

        int actual = game.round("Игрок1", "Игрок2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowDraw() {

        List<Player> players = new ArrayList<>();
        game.register(player2);
        game.register(player4);


        int expected = 0;

        int actual = game.round("Игрок2", "Игрок4");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionFirstNotRegistered() {

        List<Player> players = new ArrayList<>();
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игрок2", "Игрок4");
        });

    }

    @Test
    public void shouldThrowExceptionSecondNotRegistered() {

        List<Player> players = new ArrayList<>();
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игрок3", "Игрок7");
        });

    }

}
