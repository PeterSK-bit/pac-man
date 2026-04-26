package pacman.board.cell;

import pacman.util.Position;
import pacman.util.ScoreManager;

public class WallCell extends Cell {
    public WallCell(Position position) {
        super(position);
    }

    @Override
    public void draw() {

    }

    @Override
    public void hide() {

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
