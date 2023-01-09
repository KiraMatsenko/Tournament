import org.junit.jupiter.api.Assertions;
import ru.netology.tournament.tournament.exception.NotRegisteredException;
import org.junit.jupiter.api.Test;
import ru.netology.tournament.tournament.game.Game;
import ru.netology.tournament.tournament.player.Player;

import java.util.Arrays;
import java.util.List;


public class TournamentTests {
    Player player1 = new Player(1, "First", 1);
    Player player2 = new Player(2, "Second", 5);
    Player player3 = new Player(3, "Third", 1);
    Player player4 = new Player(4, "Fourth", 3);
    Player player5 = new Player(5, "Fifth", 6);
    Game game = new Game();

    @Test
    public void shouldAddPlayer() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        List<Player> expected = Arrays.asList(player1, player2, player3, player4, player5);
        List<Player> actual = game.getPlayers();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindPlayer() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Player expected = player3;
        Player actual = game.findById("Third");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindPlayer() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Player expected = null;
        Player actual = game.findById("Kolya");

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
    public void firstPLayerNotRegistered() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Kolya", "First"));
    }

    @Test
    public void secondPLayerNotRegistered() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("First", "Kolya"));
    }

    @Test
    public void roundShouldReturnResult() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        Assertions.assertEquals(1, game.round("Fifth", "First"));
    }

}
