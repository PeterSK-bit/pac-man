package pacman.entity;

import pacman.board.Board;
import pacman.board.cell.Cell;
import pacman.util.Direction;
import pacman.util.Position;
import fri.shapesge.Image;

public abstract class Entity {
    private Position position;
    private int speed;
    private Direction direction;
    private Image sprite;

    public Entity(Position position, int speed, Direction direction) {
        this.position = position;
        this.speed = speed;
        this.direction = direction;
    }

    public Entity(int startCol, int startRow, int speed, Direction direction) {
        this(new Position(startCol * Cell.SIZE, startCol * Cell.SIZE), speed, direction);
    }

    public abstract void move(Board board);


    public abstract void draw();


    public void hide() {
        if (this.sprite != null) {
            this.sprite.makeInvisible();
        }
    }

    public void show() {
        if (this.sprite != null) {
            this.sprite.makeVisible();
        }
    }

    public int getCol() {
        return (this.position.getX() + Cell.SIZE / 2) / Cell.SIZE;
    }

    public int getRow() {
        return (this.position.getY() + Cell.SIZE / 2) / Cell.SIZE;
    }

    public int getX() {
        return this.position.getX();
    }
    public int getY() {
        return this.position.getY();
    }

    public Position getPosition() {
        return this.position;
    }

    public int getSpeed() {
        return this.speed;
    }
    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    protected boolean isAlignedToGrid() {
        return (this.position.getX() % Cell.SIZE == 0) && (this.position.getY() % Cell.SIZE == 0);
    }

    /**
     * Overí či môže entita urobiť krok v danom smere.
     */
    protected boolean canMove(Direction dir, Board board) {
        int nextCol = this.getCol() + dir.dx();
        int nextRow = this.getRow() + dir.dy();
        return board.isWalkable(nextRow, nextCol);
    }
}
