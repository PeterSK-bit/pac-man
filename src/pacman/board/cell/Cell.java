package pacman.board.cell;

import pacman.util.Position;
import pacman.util.ScoreManager;

public abstract class Cell {
    public static final int SIZE = 32;

    private Position position;

    public Cell(Position position) {
        this.position = position;
    }

    public Cell(int row, int column) {
        this(new Position(column, row));
    }

    public int getRow() {
        return this.position.getY();
    }

    public int getCol() {
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
