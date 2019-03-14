package leetcode.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * 【存在重复元素】
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;

        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (numSet.contains(nums[i]))
                return true;
            else
                numSet.add(nums[i]);
        }

        return false;
    }
}
