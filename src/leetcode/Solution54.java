package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 【螺旋矩阵】
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int rows = matrix.length;
        if (rows == 0)
            return list;
        int cols = matrix[0].length;

        int count = 0;
        int direction = 0;
        int border;
        while (count < rows * cols) {
            switch (direction) {
                case 0:
                case 3:
                    border = cols;
                    break;
                case 1:
                case 2:
                    break;
            }

            for (int i = 0; i < ; i++) {

            }
        }

        return list;
    }
}
