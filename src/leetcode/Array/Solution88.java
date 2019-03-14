package leetcode.Array;

/**
 * 【合并两个有序数组】
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count = 0;
        int i = m - 1, j = n - 1;
        while (count < m + n && i >=0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[m + n - 1 - count++] = nums1[i--];
            else
                nums1[m + n - 1 - count++] = nums2[j--];
        }
        while (i >= 0) {
            nums1[m + n - 1 - count++] = nums1[i--];
        }
        while (j >= 0) {
            nums1[m + n - 1 - count++] = nums2[j--];
        }
    }
}
