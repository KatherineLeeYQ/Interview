package leetcode.Array;

import java.util.TreeSet;

/**
 * 【和相同的二元子数组】
 * 在由若干 0 和 1 组成的数组 A 中，有多少个和为 S 的【非空】子数组。
 */
public class Solution930 {
    public int numSubarraysWithSum(int[] A, int S) {
        int len = A.length;

        // S的取值范围为0～len，一共len+1种
        // presum[sum]: sum距离sum+1的下标距离
        int[] presum = new int[len + 1];

        int sum = 0;
        int total = 0;

        for (int i = 0; i < len; i++){
            sum += A[i];

            // 找到前一个
            int compliment = sum - S;

            if (compliment >= 0)
                // 本次S的起点距离上个1位置的距离（即可产生多少个子数组）
                total += presum[compliment];

            // 如果是刚达到S，那么则需要加上一次本数组（前面都是0）
            if (sum == S)
                total++;

            presum[sum] += 1;
        }

        return total;
    }

    public static void main(String[] args) {
//        int[] nums = {1,0,1,0,1};
        int[] nums = {0,0,1,0,0,1,1,0,0,0,0};

        Solution930 s = new Solution930();
        s.numSubarraysWithSum(nums, 2);
    }
}
