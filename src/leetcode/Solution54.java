package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 【螺旋矩阵】
 *
 * Note:
 * 不知道说什么，给写出这个解法的人点赞吧...
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int rows = matrix.length;
        if (rows == 0)
            return list;
        int cols = matrix[0].length;

        // 已访问的元素个数
        int count = 0;
        // 即将要访问的坐标
        int i = 0, j = 0;
        // i和j的增量
        int di = 0; // 1,   0,  -1
        int dj = 1; // 0,  -1,   0
        int tmpdi;

        // 用来标志是否访问过该位置的元素，若访问过，则转向
        int[][] mark = new int[rows][cols];
        while (count < rows * cols) {
            mark[i][j] = 1;
            list.add(matrix[i][j]);
            count++;
            // java的取模有点特殊, 负数参与的取模运算规则：
            // 先忽略负号，按照正数运算之后，被取模的数是正数结果就取正，反之取负。
            // 注：(-2)%5中被取模数是-2
            if (mark[Math.abs(i + di) % rows][Math.abs(j + dj) % cols] == 1) {
                tmpdi = di;
                di = dj;
                dj = -tmpdi;
            }

            i += di;
            j += dj;
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}};

        Solution54 s = new Solution54();
        s.spiralOrder(matrix);
    }
}
