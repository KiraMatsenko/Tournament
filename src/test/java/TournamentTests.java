import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.tournament.tournament.exception.NotRegisteredException;
import ru.netology.tournament.tournament.game.Game;
import ru.netology.tournament.tournament.player.Player;

import java.util.HashMap;


public class TournamentTests {
    Player player1 = new Player(1, 1);
    Player player2 = new Player(2, 5);
    Player player3 = new Player(3, 1);
    Player player4 = new Player(4, 3);
    Player player5 = new Player(5, 6);
    Game game = new Game();

    @Test
    public void shouldAddPlayer() {
        game.register("First", player1);
        game.register("Second", player2);
        game.register("Third", player3);
        game.register("Fourth", player4);
        game.register("Fifth", player5);

        HashMap<String, Player> expected = new HashMap<>();
        expected.put("First", player1);
        expected.put("Second", player2);
        expected.put("Third", player3);
        expected.put("Fourth", player4);
        expected.put("Fifth", player5);

        HashMap<String, Player> actual = game.getPlayersList();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByName() {
        game.register("First", player1);
        game.register("Second", player2);
        game.register("Third", player3);
        game.register("Fourth", player4);
        game.register("Fifth", player5);

        Player expected = player3;
        Player actual = game.findByName("Third");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByName() {
        game.register("First", player1);
        game.register("Second", player2);
        game.register("Third", player3);
        game.register("Fourth", player4);
        game.register("Fifth", player5);

        Player expected = null;
        Player actual = game.findByName("Kolya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareShouldReturnPlus() {
        int expected = 1;
        int actual = game.compare(player5, player1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareShouldReturnMinus() {
        int expected = -1;
        int actual = game.compare(player1, player5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareShouldReturnZero() {
        int expected = 0;
        int actual = game.compare(player3, player1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPLayerNotRegistered() { //!!!
        game.register("First", player1);
        game.register("Second", player2);
        game.register("Third", player3);
        game.register("Fourth", player4);
        game.register("Fifth", player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Kolya", "First"));
    }

    @Test
    public void secondPLayerNotRegistered() { //!!!
        game.register("First", player1);
        game.register("Second", player2);
        game.register("Third", player3);
        game.register("Fourth", player4);
        game.register("Fifth", player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("First", "Kolya"));
    }

    @Test
    public void roundShouldReturnResult() { //!!!
        game.register("First", player1);
        game.register("Second", player2);
        game.register("Third", player3);
        game.register("Fourth", player4);
        game.register("Fifth", player5);

        Assertions.assertEquals(1, game.round("Fifth", "First"));
    }
}
