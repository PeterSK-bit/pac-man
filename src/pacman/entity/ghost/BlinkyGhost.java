package pacman.entity.ghost;

import fri.shapesge.Image;
import pacman.board.Board;
import pacman.util.Direction;

public class BlinkyGhost extends Ghost {
    private static final String SPRITE_DIR = "resources/ghosts/blinky";

    private int frameIndex = 0;

    public BlinkyGhost(int startCol, int startRow, Direction direction) {
        super(startCol, startRow, direction);
        this.setSprite(new Image(String.format("%s/%s%d.png", SPRITE_DIR, this.getDirection().name(), this.frameIndex)));
        this.getSprite().changePosition(startCol * CELL_SIZE, startRow * CELL_SIZE);
        this.getSprite().makeVisible();
    }

    @Override
    public Direction calculateNextMove(Board board) {
        return null;
    }

    @Override
    protected String getNormalSpriteName() {
        return "";
    }

    @Override
    public void update() {
        this.frameIndex = (this.frameIndex + 1) % NUM_FRAMES;
    }

    @Override
    public void render() {
        this.getSprite().changeImage(String.format("%s/%s%d.png", SPRITE_DIR, this.getDirection().name(), this.frameIndex));
    }
}
