package leetcode.Array;

/**
 * 【螺旋矩阵 II】
 *
 * Note:
 * 第54题的稍微变更版本
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        // 已访问的元素个数， 总元素个数
        int count = 0, total = n * n;
        // 即将要访问的坐标
        int i = 0, j = 0;
        // i和j的增量
        int di = 0, dj = 1;
        int tmpdi;

        while (count < total) {
            matrix[i][j] = count + 1;
            count++;

            // 由于初始化元素都为0，访问过的地方不可能为0,
            // 如果下一个访问地址中的元素不为0，代表已经访问过了，转向
            if (matrix[Math.abs(i + di) % n][Math.abs(j + dj) % n] != 0) {
                tmpdi = di;
                di = dj;
                dj = -tmpdi;
            }
            i += di;
            j += dj;
        }

        return matrix;
    }
}
