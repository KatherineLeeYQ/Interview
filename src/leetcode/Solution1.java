package leetcode;

import java.util.*;

/**
 * 【两数之和】
 * Note:
 * 边判断边处理数据，不要先处理完数据再来判断
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        int len = nums.length;
        // 边判断边处理数据，不要先处理完数据再来判断
        for (int i = 0; i < len; i++) {
            int partner = target - nums[i];
            // 这里不要写map.keySet().contains(partner) && map.get(partner) != i
            // 太费内存（多调用了一次方法）
            if (map.getOrDefault(partner, i) != i) {
                res[0] = i;
                res[1] = map.get(partner);
                break;
            }
            else {
                map.put(nums[i], i);
            }
        }

        return res;
    }
}
