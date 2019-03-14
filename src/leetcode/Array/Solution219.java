package leetcode.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 【存在重复元素 II】
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 存在重复元素：217题
 */
public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;

        Map<Integer, Integer> indexMap = new HashMap<>();
        int index;
        for (int i = 0; i < len; i++) {
            index = indexMap.getOrDefault(nums[i], -1);
            if (index != -1 && Math.abs(index - i) <= k)
                return true;
            else
                indexMap.put(nums[i], i);
        }

        return false;
    }
}
