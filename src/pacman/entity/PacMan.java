package pacman.entity;

import fri.shapesge.Image;
import pacman.board.Board;
import pacman.util.Direction;
import pacman.util.Position;

public class PacMan extends Entity {
    private Direction pendingDirection;
    private boolean powerMode;
    private int powerTimer;
    private static final String[] FRAMES = {"resources/pacman/0.png", "resources/pacman/1.png", "resources/pacman/2.png"};
    private int frameIndex;

    public PacMan(Position position) {
        super(position, 5, Direction.RIGHT);
        this.powerMode = false;
        this.powerTimer = 0;
        this.frameIndex = 0;
        this.setSprite(new Image(FRAMES[this.frameIndex]));
        this.getSprite().changePosition(position.getX(), position.getY());
        this.getSprite().makeVisible();
    }

    @Override
    public void render() {
        this.getSprite().changeImage(FRAMES[this.frameIndex]);
        switch (this.getDirection()) {
            case RIGHT:
                this.getSprite().changeAngle(0);
                break;
            case LEFT:
                this.getSprite().changeAngle(180);
                break;
            case UP:
                this.getSprite().changeAngle(-90);
                break;
            case DOWN:
                this.getSprite().changeAngle(90);
                break;
            case NONE:
                System.out.println("PacMan has no direction!");
                break;
        }

    }

    @Override
    public void update() {
        this.frameIndex = (this.frameIndex + 1) % FRAMES.length;
    }

    @Override
    public void move(Board board) {

    }
}
