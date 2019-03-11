package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 【两数之和 II - 输入有序数组】
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            int partner = target - numbers[i];
            if (map.getOrDefault(partner, i) != i) {
                res[0] = map.get(partner) + 1;
                res[1] = i + 1;
                break;
            }
            else {
                map.put(numbers[i], i);
            }
        }

        return res;
    }
}
