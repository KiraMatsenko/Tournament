package ru.netology.tournament.tournament.game;

import ru.netology.tournament.tournament.exception.NotRegisteredException;
import ru.netology.tournament.tournament.player.Player;
import java.util.ArrayList;
import java.util.Comparator;

public class Game implements Comparator<Player> {
    ArrayList<Player> playersList = new ArrayList<>();

    public ArrayList<Player> getPlayers() {
        return playersList;
    }

    public void register (Player player) {
        playersList.add(player);
    }

    public Player findById(String name) {
        for (Player player : playersList) {
            if (name == player.getName()) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = new Player();
        Player player2 = new Player();
        if (findById(playerName1) == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован");
        } else if (findById(playerName2) == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован");
        } else {
            for (Player player : playersList) {
                if (player.getName() == playerName1) {
                    player1 = player;
                }
            }
            for (Player player : playersList) {
                if (player.getName() == playerName2) {
                    player2 = player;
                }
            }
        }
        return (compare(player1,player2));
    }

    public int compare(Player o1, Player o2) {
        if (o1.getStrength() < o2.getStrength()){
            return -1;
        } else if (o1.getStrength() > o2.getStrength()) {
            return 1;
        } else {
            return 0;
        }
    }
}
