package pacman.board;

import pacman.board.cell.Cell;

public class Board {
    private Cell[][] grid;
    private int remainingDots;

    public Board() {

    }

    public Cell getCell(int col, int row) {
        return this.grid[col][row];
    }

    public boolean isWalkable(int col, int row) {
        return this.getCell(col, row).isWalkable();
    }

    public int getRemainingDots() {
        return this.remainingDots;
    }
}
