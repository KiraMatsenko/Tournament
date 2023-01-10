package ru.netology.tournament.tournament.player;

public class Player {
    int id;
    int strength;

    public Player() {
    }

    public Player(int id, int strength) {
        this.id = id;
        this.strength = strength;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
