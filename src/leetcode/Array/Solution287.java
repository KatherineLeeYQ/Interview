package leetcode.Array;

/**
 * 【寻找重复数】
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * Note:
 * 1. 使用快慢指针
 * 2. 使用二分查找
 */
public class Solution287 {
    public int findDuplicate(int[] nums) {
        // 数组下标作为地址值，数组元素值作为节点值（下一个节点地址值，相当于next）
        int fast = 0, slow = 0;
        // 由于题目一定会有重复值，故while(true)
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];

            // 快指针地址值 == 慢指针地址值
            if (fast == slow) {
                fast = 0;
                while (nums[fast] != nums[slow]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
}
