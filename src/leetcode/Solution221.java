package leetcode;

/**
 * Note:
 * 思路同Solution85
 */
public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int rowCount = matrix.length;
        if (rowCount == 0) return 0;
        int itemCount = matrix[0].length;

        int[][] dp = new int[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            int[] row = new int[itemCount];
            for (int j = 0; j < itemCount; j++) {
                if (matrix[i][j] != '0') {
                    row[j] = 1;
                    row[j] += j > 0 ? row[j-1] : 0;
                }
                else {
                    row[j] = 0;
                }
            }
            dp[i] = row;
        }

        int area = 0;
        for (int j = 0; j < itemCount; j++) {
            for (int i = 0; i < rowCount; i++) {
                int width = 0;
                int minHeight = Integer.MAX_VALUE;
                for (int k = i; k >= 0; k--) {
                    if (dp[k][j] != 0) {
                        width += 1;
                        minHeight = Math.min(minHeight, dp[k][j]);

                        int sideWidth = Math.min(width, minHeight);
                        area = Math.max(area, sideWidth * sideWidth);
                    }
                    else {
                        width = 0;
                    }
                }
            }
        }

        return area;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','1','1','1'},
                {'1','1','1','1'},
                {'1','1','1','1'}};

        Solution221 s = new Solution221();
        s.maximalSquare(matrix);
    }
}
