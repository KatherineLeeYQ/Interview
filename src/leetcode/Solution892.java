package leetcode;

public class Solution892 {
    public int surfaceArea(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        int cubCount = 0;
        int cubDot = 0;
        int overlap = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] != 0) ++cubDot;
                cubCount += grid[i][j];

                // right
                if (j + 1 < columns)
                    overlap += Math.min(grid[i][j], grid[i][j+1]);
                // down
                if (i + 1 < rows)
                    overlap += Math.min(grid[i][j], grid[i+1][j]);
            }
        }

        return cubCount * 4 + cubDot * 2 - overlap * 2;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2}, {3, 4}};

        Solution892 s = new Solution892();
        s.surfaceArea(grid);
    }
}
