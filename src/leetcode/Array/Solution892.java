package leetcode.Array;

/**
 * 【三维形体的表面积】
 * Note:
 * 主要是发现公式
 */
public class Solution892 {
    public int surfaceArea(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        // 网格（i,j）上如果有Xi个立方体，那么总面积就是6Xi-2(Xi-1)=4Xi+2
        // 一旦两个立方体挨着，挨着一个面，损失表面积2
        // 网格上下左右都可能出现挨着的面，挨着是相互的，那么每个网格只观察两个面就够了

        // 一共有多少个立方体
        int cubCount = 0;
        // 一共有多少个网格放了立方体
        int cubDot = 0;
        // 立方体挨着的面有几个
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
