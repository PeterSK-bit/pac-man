package pacman.game;

import fri.shapesge.Manager;
import pacman.board.Board;
import pacman.entity.PacMan;
import pacman.entity.ghost.BlinkyGhost;
import pacman.entity.ghost.ClydeGhost;
import pacman.entity.ghost.Ghost;
import pacman.entity.ghost.InkyGhost;
import pacman.entity.ghost.PinkyGhost;
import pacman.util.Direction;
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


        // TESTING ------------------
        this.ghosts.add(new PinkyGhost(4, 0, Direction.DOWN));
        this.ghosts.add(new BlinkyGhost(4, 4, Direction.RIGHT));
        this.ghosts.add(new ClydeGhost(4, 8, Direction.UP));
        this.ghosts.add(new InkyGhost(4, 12, Direction.LEFT));
        // --------------------------

        this.gameState = GameState.RUNNING;
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
        if (this.gameState == GameState.RUNNING) {
            this.pacMan.render();
            this.pacMan.update();

            for (Ghost ghost : this.ghosts) {
                ghost.render();
                ghost.update();
            }
        }

    }
}
