package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    // Тесты register
    // Добавление нового игрока
    @Test
    public void registerNewPlayerRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "One", 10);
        game.register(player1);

        boolean expected = true;
        boolean actual = game.players.contains(player1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void registerNewPlayerNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "One", 10);
        Player player2 = new Player(2, "Two", 20);
        game.register(player1);

        boolean expected = false;
        boolean actual = game.players.contains(player2);
        Assertions.assertEquals(expected, actual);
    }

    // Тесты round
    // Игрок 1 есть, игрока 2 нет
    @Test
    public void roundPlayer1ExistsPlayer2NotExist() {
        Game game = new Game();
        Player player1 = new Player(1, "One", 10);
        Player player2 = new Player(2, "Two", 20);
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("One", "Two")
        );
    }
    // Игрока 1 нет, игрок 2 есть
    @Test
    public void roundPlayer1NotExistPlayer2Exists() {
        Game game = new Game();
        Player player1 = new Player(1, "One", 10);
        Player player2 = new Player(2, "Two", 20);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("One", "Two")
        );
    }

    // Оба есть; 1-й сильнее
    @Test
    public void roundBothPlayersExistPlayer1Win() {
        Game game = new Game();
        Player player1 = new Player(1, "One", 100);
        Player player2 = new Player(2, "Two", 20);
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("One", "Two");
        Assertions.assertEquals(expected, actual);
    }

    // Оба есть; 2-й сильнее
    @Test
    public void roundBothPlayersExistPlayer2Win() {
        Game game = new Game();
        Player player1 = new Player(1, "One", 10);
        Player player2 = new Player(2, "Two", 20);
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("One", "Two");
        Assertions.assertEquals(expected, actual);
    }

    // Оба есть; ничья
    @Test
    public void roundBothPlayersExistDraw() {
        Game game = new Game();
        Player player1 = new Player(1, "One", 10);
        Player player2 = new Player(2, "Two", 10);
        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("One", "Two");
        Assertions.assertEquals(expected, actual);
    }

    // Тесты геттеров
    // getId
    @Test
    public void shouldGetID() {
        Game game = new Game();
        Player player1 = new Player(1, "One", 10);
        game.register(player1);

        int expected = 1;
        int actual = player1.getId();
        Assertions.assertEquals(expected, actual);
    }

    // getName (не обязательно?)
    // getStrength (не обязательно?)
}
