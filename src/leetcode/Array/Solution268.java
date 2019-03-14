package leetcode.Array;

/**
 * 【缺失数字】
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */
public class Solution268 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int res = len * (len + 1) / 2;

        for (int i = 0; i < len; i++) {
            res -= nums[i];
        }

        return res;
    }
}
