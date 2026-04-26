package pacman.util;

import pacman.board.Board;

import java.util.ArrayList;
import java.util.List;

public class GraphBuilder {

    private GraphBuilder() { }

    public static int[][] build(Board board, int rows, int cols) {
        int totalCells = rows * cols;
        int[][] adjacency = new int[totalCells][];

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int index = row * cols + col;

                if (!board.isWalkable(row, col)) {
                    adjacency[index] = new int[0];
                    continue;
                }

                List<Integer> neighbors = new ArrayList<>();
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                            && board.isWalkable(newRow, newCol)) {
                        neighbors.add(newRow * cols + newCol);
                    }
                }

                adjacency[index] = neighbors.stream().mapToInt(Integer::intValue).toArray();
            }
        }

        return adjacency;
    }

    public static int toIndex(int row, int col, int cols) {
        return row * cols + col;
    }

    public static int toRow(int index, int cols) {
        return index / cols;
    }

    public static int toCol(int index, int cols) {
        return index % cols;
    }
}