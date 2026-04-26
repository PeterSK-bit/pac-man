package pacman.game;

import fri.shapesge.Manager;
import pacman.board.Board;
import pacman.entity.PacMan;
import pacman.entity.ghost.Ghost;
import pacman.util.GameState;
import pacman.util.Position;
import pacman.util.ScoreManager;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Board board;
    private final ScoreManager scoreManager;
    private final PacMan pacMan;
    private final List<Ghost> ghosts;
    private GameState gameState;

    public Game() {
        Manager manager = new Manager();
        manager.manageObject(this);

        this.board =  new Board();
        this.pacMan = new PacMan(new Position(0, 0));
        this.scoreManager = new ScoreManager();
        this.ghosts = new ArrayList<>();
        this.gameState = GameState.RUNNING;

        // TESTING
        this.ghosts.add(new )
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
        this.pacMan.render();
        this.pacMan.update();

        for (Ghost ghost : this.ghosts) {
            ghost.render();
            ghost.update();
        }
    }
}
