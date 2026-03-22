package pacman.board.cell;

import pacman.util.Position;
import pacman.util.ScoreManager;

public abstract class Cell {
    private final int size = 32;

    private Position position;

    public Cell(Position position) {
        this.position = position;
    }

    public Cell(int x, int y) {
        this(new Position(x, y));
    }

    public int getY() {
        return this.position.getY();
    }

    public int getX() {
        return this.position.getX();
    }

    public Position getPosition() {
        return this.position;
    }

    public abstract void draw();

    public abstract void hide();

    public abstract void onEnter(ScoreManager scoreManager);

    public abstract boolean isWalkable();


}
