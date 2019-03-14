package leetcode.Array;

/**
 * 【只出现一次的数字】
 *
 * Note:
 * 异或：  0^0=0;   0^1=1;  1^0=1;  1^1=0;
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
