package pacman.board.cell;

import fri.shapesge.Square;
import pacman.util.Position;
import pacman.util.ScoreManager;

public class WallCell extends Cell {
    private final Square sprite;

    public WallCell(Position position) {
        super(position);
        this.sprite = new Square();
        this.sprite.changeColor("black");
        this.sprite.changePosition(this.getCol() * SIZE, this.getRow() * SIZE);
        this.sprite.changeSize(SIZE);
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
    public void onEnter(ScoreManager scoreManager) {
        throw new IllegalStateException("can't enter wall");
    }

    @Override
    public boolean isWalkable() {
        return false;
    }
}
