package leetcode;

/**
 * 【翻转图像】
 * Note:
 * 一个整数i，若它是0则变为1，若它是1则变为0.
 * 用 i = i ^ 1;
 * 比用i = i % 2 == 0 ? 1 : 0;
 * 要好。
 */
public class Solution832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int count = A.length;

        int end = count - 1;
        int mid = end / 2;
        for (int i = 0; i < count; ++i) {
            for (int j = 0; j <= mid; ++j) {
                int tmp = A[i][j];
                A[i][j] = A[i][end - j] % 2 == 0 ? 1 : 0;
                A[i][end - j] = tmp % 2 == 0? 1 : 0;
            }
        }

        return A;
    }
}
