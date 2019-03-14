package leetcode.Array;

/**
 * 【最大矩形】：二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积
 * Note:
 * 思路类似Solution84
 * https://blog.csdn.net/qq_41855420/article/details/87459549
 */
public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int rowCount = matrix.length;
        if (rowCount == 0)
            return 0;

        int itemCount = matrix[0].length;

        // 每行从左往右，算出在格点处连续的最大高度
        int[][] dp = new int[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            int[] height = new int[itemCount];
            for (int j = 0; j < itemCount; j++) {
                if (matrix[i][j] == '1') {
                    height[j] = 1;
                    height[j] += j > 0 ? height[j-1] : 0;
                }
                else {
                    height[j] = 0;
                }
            }

            dp[i] = height;
        }

        int area = 0;
        // 对于得到的dp数组：
        // 每次多露出一列：第一次露出第0列，第二次露出第0,1列，第三次露出第0,1,2列...
        // 将列作为底
        for (int j = 0; j < itemCount; j++) {
            int width = 0;
            int minHeight = Integer.MAX_VALUE;
            // 遍历每一行，每行都与之前的行进行合并，从而产生最大的面积
            for (int i = 0; i < rowCount; i++) {
                // 算最大连续格点能产生的面积
                if (dp[i][j] != 0) {
                    width += 1;
                    minHeight = Math.min(minHeight, dp[i][j]);
                }
                if (dp[i][j] == 0 || i == rowCount - 1) {
                    area = Math.max(area, width * minHeight);
                    width = 0;
                }

                // 最大连续格点计算时，有可能在宽度增加后，由于高度变小，面积反倒变小
                // 算连续格点的【子集】能产生的最大面积
                int subWidth = 0;
                minHeight = Integer.MAX_VALUE;
                for (int k = i; k >= 0; k--) {
                    if (dp[k][j] != 0) {
                        subWidth += 1;
                        minHeight = Math.min(minHeight, dp[k][j]);
                        area = Math.max(area, subWidth * minHeight);
                    }
                    if (dp[k][j] == 0)
                        break;
                }
            }

        }

        return area;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'0','1','1','0','1'},
                {'1','1','0','1','0'},
                {'0','1','1','1','0'},
                {'1','1','1','1','0'},
                {'1','1','1','1','1'},
                {'0','0','0','0','0'}};
        /**
         * 每行从左往右，算出在格点处连续的最大高度，如下图
         * [0 1 2 0 1]
         * [1 2 0 1 0]
         * [0 1 2 3 0]
         * [1 2 3 4 0]
         * [1 2 3 4 5]
         * [0 0 0 0 0]
         */

        Solution85 s = new Solution85();
        s.maximalRectangle(matrix);
    }
}
