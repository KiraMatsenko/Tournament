package ru.netology.tournament.tournament.game;

import ru.netology.tournament.tournament.exception.NotRegisteredException;
import ru.netology.tournament.tournament.player.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Game implements Comparator<Player> {
    private HashMap<String, Player> playersList = new HashMap<>();

    public HashMap<String, Player> getPlayersList() {
        return playersList;
    }

    public void register(String playerName, Player player) {
        playersList.put(playerName, player);
    }

    public Player findByName(String name) {
        Player found = new Player();
        for (String key : playersList.keySet()) {
            Player result = playersList.get(name);
            found = result;
        }
        return found;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = new Player();
        Player player2 = new Player();
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован");
        } else if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован");
        } else {
            for (String key : playersList.keySet()) {
                Player p1 = playersList.get(playerName1);
                player1 = p1;
            }
        }
        for (String key : playersList.keySet()) {
            Player p2 = playersList.get(playerName2);
            player2 = p2;
        }
        return (compare(player1, player2));
    }

    public int compare(Player o1, Player o2) {
        if (o1.getStrength() < o2.getStrength()) {
            return -1;
        } else if (o1.getStrength() > o2.getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }
}
