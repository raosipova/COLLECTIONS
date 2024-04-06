package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class GameTest {


    Player player1 = new Player(1, "Оля", 15);
    Player player2 = new Player(2, "Петя", 25);
    Player player3 = new Player(3, "Коля", 28);
    Player player4 = new Player(4, "Настя", 9);
    Player player5 = new Player(5, "Олег", 28);

    Game game = new Game();

    @Test
    public void firstPlayerWon() {
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Петя", "Оля");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWon() {
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Оля", "Петя");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playersWereEqual() {
        game.register(player3);
        game.register(player5);

        int expected = 0;
        int actual = game.round("Коля", "Олег");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstNotRegistered() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Оля", "Игорь");
        });
    }

    @Test
    public void secondNotRegistered() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Петя", "Настя");
        });
    }

    @Test
    public void bothNotRegistered() {
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Игорь", "Петя");
        });
    }
}