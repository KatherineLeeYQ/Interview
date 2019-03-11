package leetcode;

/**
 * 【路径交叉】
 */
public class Solution335 {
    public boolean isSelfCrossing(int[] x) {
        for (int i = 3; i < x.length; ++i) {
            // 本圈交叉
            if (x[i] >= x[i - 2] && x[i - 3] >= x[i - 1]) {
                return true;
            }
            // 内部交叉
            if (i >= 4 && x[i-1] == x[i-3] && x[i] >= x[i-2] - x[i-4]) {
                return true;
            }
            // 外部交叉
            if (i >= 5 && x[i-2] >= x[i-4] && x[i-3] >= x[i-1] && x[i-1] >= x[i-3] - x[i-5] && x[i] >= x[i-2] - x[i-4]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] x = {3,3,4,2,2};
        Solution335 s = new Solution335();
        s.isSelfCrossing(x);
    }
}
