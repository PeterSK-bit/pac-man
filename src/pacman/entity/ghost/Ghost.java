package pacman.entity.ghost;

import pacman.board.Board;
import pacman.entity.Entity;
import pacman.util.Direction;
import pacman.util.GhostState;

public abstract class Ghost extends Entity {
    private static final int SPEED = 2;
    private static final int FRIGHTENED_TICKS = 200;

    private GhostState state;
    private final int homeCol;
    private final int homeRow;
    private int frightenedTimer;

    public Ghost(int startCol, int startRow, Direction direction) {
        super(startCol, startRow, SPEED, direction);
        this.homeCol = startCol;
        this.homeRow = startRow;
        this.state = GhostState.CHASE;
    }

    public abstract Direction calculateNextMove(Board board);

    @Override
    public void move(Board board) {
        if (this.state == GhostState.RESPAWNING) {
            this.moveToHome();
            return;
        }

        if (this.state == GhostState.FRIGHTENED) {
            this.frightenedTimer--;
            if (this.frightenedTimer <= 0) {
                this.state = GhostState.CHASE;
                this.updateSprite();
            }
        }

        // TODO after implementation of graph
    }

    @Override
    public void draw() {
        this.getSprite().changePosition(this.getPosition().getX(), this.getPosition().getY());
    }

    public void setFrightened() {
        if (this.state != GhostState.RESPAWNING) {
            this.state = GhostState.FRIGHTENED;
            this.frightenedTimer = FRIGHTENED_TICKS;
            this.updateSprite();
        }
    }

    public void respawn() {
        this.state = GhostState.CHASE;
        this.updateSprite();
    }

    public void onCaught() {
        this.state = GhostState.RESPAWNING;
        this.setDirection(Direction.NONE);
        this.draw();
        this.updateSprite();
        this.moveToHome();
    }

    private void moveToHome() {
        if (this.getCol() == this.homeCol && this.getRow() == this.homeRow) {
            this.respawn();
        } else {
            // TODO pathfinding using graph
        }
    }

    protected void updateSprite() {
        String imageName = switch (this.state) {
            case FRIGHTENED -> "ghost_frightened.png";
            case RESPAWNING -> "ghost_eyes.png";
            default -> this.getNormalSpriteName();
        };
        this.getSprite().changeImage(imageName);
    }

    /**
     * Picture name of ghost in normal state
     */
    protected abstract String getNormalSpriteName();

    public GhostState getState() {
        return this.state;
    }

    public boolean isFrightened() {
        return this.state == GhostState.FRIGHTENED;
    }
}
