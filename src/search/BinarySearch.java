package search;

/**
 * 【二分查找】
 * 前提要求：元素必须是有序的，如果无序，则先排序
 * 复杂度分析：最坏情况下，关键词比较次数为log2(n+1)，且期望时间复杂度为O(log2n)；
 *
 * 折半查找的前提条件是需要有序表顺序存储，对于静态查找表，一次排序后不再变化，折半查找能得到不错的效率。
 * 但对于需要频繁执行插入或删除操作的数据集来说，维护有序的排序会带来不小的工作量，那就不建议使用。
 *                                                                      ——《大话数据结构》
 */
public class BinarySearch {
    public int binarySearch_Unrecursive(int[] arr, int value) {
        int len = arr.length;

        int left = 0;
        int right = len - 1;
        int mid;
        while (left <= right) {
            mid = left/2 + right/2;
            if (value > arr[mid])
                left = mid + 1;
            else if (value < arr[mid])
                right = mid - 1;
            else
                return mid;
        }

        return -1;
    }
}
