package search;

/**
 * 【插值查找】
 * 基本思想：基于二分查找算法，将查找点的选择改进为自适应选择，可以提高查找效率。差值查找也属于有序查找。
 * 复杂度分析：查找成功或者失败的时间复杂度均为O(log2(log2n))。
 *
 * 注： 对于表长较大，而***【关键字分布又比较均匀】***的查找表来说，插值查找算法的平均性能比折半查找要好的多。
 *     反之，数组中如果分布非常不均匀，那么插值查找未必是很合适的选择。
 */
public class InsertionSearch {
    // 元素默认升序排序
    public int insertionSearch(int[] arr, int value) {
        int len = arr.length;

        int left = 0;
        int right = len - 1;
        int mid;
        while (left <= right) {
            mid = (left - right) * (value - arr[left])/(arr[right] - arr[left]) + left;
            if (value <= arr[mid])
                right = mid - 1;
            else if (value >= arr[mid])
                left = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
