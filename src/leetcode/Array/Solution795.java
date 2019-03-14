package leetcode.Array;

/**
 * 【区间子数组个数】
 */
public class Solution795 {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return numSubarrayBoundedMax(A, R) - numSubarrayBoundedMax(A, L - 1);
    }

    private int numSubarrayBoundedMax(int[] A, int max) {
        int res = 0, items = 0;
        for (int x: A) {
            if (x <= max) {
                // 每连续的符合条件的元素个数+1
                items++;
                // 则产生的子数组个数增加items+1个
                res += items;
            }
            else {
                items = 0;
            }
        }
        return res;
    }
}
