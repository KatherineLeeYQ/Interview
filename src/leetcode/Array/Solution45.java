package leetcode.Array;

/**
 * 【跳跃游戏 II】
 *
 * Note:
 * 看答案都看了半天...
 */
public class Solution45 {
    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;

        // 当前步数最远距离
        int reach = 0;
        // 当前位置跳一步后的最远距离（现在位置可达到的最远距离）
        int nextReach = nums[0];
        // 现在走了多少步
        int step = 0;

        // i ~ reach这个段位置上，是否有一个再跳一步就可到达终点的点
        for (int i = 0; i < len; i++) {
            // 更新
            nextReach = Math.max(i + nums[i], nextReach);

            // 如果当前跳一步可到达终点
            if (nextReach >= len - 1)
                return step + 1;

            // 如果当前遍历的位置
            // 已达当前可达的最远距离：必须往后跳一步，才能继续遍历
            // 还没到跳到当前可达的最远距离：可继续遍历
            if (i == reach) {
                ++step;
                reach = nextReach;
            }
        }

        return step;
    }
}
