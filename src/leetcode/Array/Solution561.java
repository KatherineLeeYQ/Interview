package leetcode.Array;

/**
 * 【数组拆分 I】
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn)
 * 使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * Note:
 * 快速排序
 */
public class Solution561 {
    public int arrayPairSum(int[] nums) {
        QuickSort(nums, 0, nums.length - 1);

        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

    private void QuickSort(int[] a, int left, int right) {
        // 把边界条件限制在QuickSort里
        // 数组为空 ||　待比较元素只有一个 || 下标不符合
        if (a == null || left >= right || left < 0 || right < 0)
            return;

        int k = Partition(a, left, right);
        QuickSort(a, left, k - 1);
        QuickSort(a, k + 1, right);
    }

    private int Partition(int[] a, int left, int right) {
        int pivot = a[left];
        int i = left;
        int j = right;

        while (i < j) {
            // 从后面开始
            while (i < j && a[j] > pivot)
                --j;
            // 小的换到前面去，本位j值待定
            if (i < j)
                a[i] = a[j];

            while (i < j && a[i] <= pivot)
                ++i;
            // 大的换到后面去，填充之前待定的j位
            if (i < j)
                a[j] = a[i];
        }
        a[i] = pivot;

        return i;
    }
}
