package leetcode.Array;

import java.util.*;

/**
 * 【存在重复元素 III】
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得：
 * 1. nums [i] 和 nums [j] 的差的绝对值最大为 t
 * 2. 并且 i 和 j 之间的差的绝对值最大为 ķ
 *
 */
public class Solution220 {
    // 我的解法，滑动窗口：570ms，很烂
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        int len = nums.length;
        if (t < 0 || k < 0)
            return false;
        if (k > len)
            k = len;

        int end;
        for (int i = 0; i < len; i++) {
            end = Math.min(len - 1, i + k);

            for (int j = i + 1; j <= end; j++) {
                if (Math.abs((long) nums[i] - nums[j]) <= t)
                    return true;
            }
        }

        return false;
    }
    // 滑动窗口+平衡树存储：44ms
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // nums[i] - t <= 另一个数 <= nums[i] + t
            long min = (long) nums[i] - t;
            // 如果窗口中存在一个>=min的数，且满足<=num[i]+t
            // 那么就满足条件，返回true
            if (set.ceiling(min) != null &&
                    set.ceiling(min) <= (long) nums[i] + t)
                return true;
            set.add((long) nums[i]);
            if (set.size() == k + 1)
                set.remove((long) nums[i - k]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,9,1,5,9};
        Solution220 s = new Solution220();
        s.containsNearbyAlmostDuplicate(nums, 2, 3);
    }
}
