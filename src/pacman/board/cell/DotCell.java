package pacman.board.cell;

import fri.shapesge.Square;
import pacman.util.Position;
import pacman.util.ScoreManager;

public class DotCell extends Cell {
    private final Square[] sprite;
    private boolean isEaten = false;

    public DotCell(Position position) {
        super(position);

        // TODO find a fitting sprites
        // place holders
        this.sprite = new Square[2];

        this.sprite[0] = new Square();
        this.sprite[0].changeColor("blue");
        this.sprite[0].changePosition(this.getCol() * SIZE, this.getRow() * SIZE);
        this.sprite[0].changeSize(SIZE);

        this.sprite[1] = new Square();
        this.sprite[1].changeColor("red");
        this.sprite[1].changePosition(this.getCol() * SIZE + (SIZE / 5 * 2), this.getRow() * SIZE + (SIZE / 5 * 2));
        this.sprite[1].changeSize(SIZE / 5);
    }

    public DotCell(int col, int row) {
        this(new  Position(col, row));
    }

    @Override
    public void draw() {
        if (this.isEaten) {
            this.sprite[0].makeVisible();
        } else  {
            this.sprite[0].makeVisible();
            this.sprite[1].makeVisible();
        }
    }

    @Override
    public void hide() {
        for (Square square : this.sprite) {
            square.makeInvisible();
        }
    }

    @Override
    public void onEnter(ScoreManager scoreManager) {
        if (this.isEaten) {
            return;
        }

        this.isEaten = true;
        this.sprite[1].makeInvisible();
        scoreManager.addDotPoints();
    }

    @Override
    public boolean isWalkable() {
        return true;
    }
}
