package leetcode;

/**
 * 【跳跃游戏】
 *
 * Note:
 * 从后往前遍历
 * 如果从当前位置是否可以到现有的最后一个格子（当前位置可跳的距离大于剩余格子数）
 * 是，则将当前位置设置为最后一个格子
 * 否，则将剩余格子数（n）增加1
 * 遍历结束后，若最后剩余格子数为1，即为true；否则为false
 *
 * 贪心算法：https://www.jianshu.com/p/b613ae9d77ff
 */
public class Solution55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;

        int n = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] > n)
                n = 1;
            else
                n++;
        }
        if (n > 1)
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        Solution55 s = new Solution55();
        s.canJump(nums);
    }
}
