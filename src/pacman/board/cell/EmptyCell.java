package pacman.board.cell;

import fri.shapesge.Square;
import pacman.util.Position;
import pacman.util.ScoreManager;

public class EmptyCell extends Cell {
    private final Square sprite;

    public EmptyCell(Position position) {
        super(position);
        this.sprite = new Square();
        this.sprite.changeColor("blue");
        this.sprite.changePosition(this.getCol() * SIZE, this.getRow() * SIZE);
        this.sprite.changeSize(SIZE);
    }

    public EmptyCell(int row, int col) {
        this(new  Position(col, row));
    }

    @Override
    public void draw() {
        this.sprite.makeVisible();
    }

    @Override
    public void hide() {
        this.sprite.makeInvisible();
    }

    @Override
    public void onEnter(ScoreManager scoreManager) { } // nothing

    @Override
    public boolean isWalkable() {
        return true;
    }
}
