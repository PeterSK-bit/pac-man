package pacman.game;

import fri.shapesge.Manager;

public class Game {

    public Game() {
        Manager manager = new Manager();
        manager.manageObject(this);
    }

    public void up() {
        System.out.println("up event triggered");
    }

    public void down() {
        System.out.println("down event triggered");
    }

    public void left() {
        System.out.println("left event triggered");
    }

    public void right() {
        System.out.println("right event triggered");
    }

    public void escape() {
        System.out.println("escape event triggered");
    }

    public void tick() {
        System.out.println("tick event triggered");
    }
}
