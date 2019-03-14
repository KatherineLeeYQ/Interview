package sort;

import java.util.Arrays;

/**
 * 【快速排序】：一种交换类的排序，它同样是分治法的经典体现。
 * 1. 在一趟排序中将待排序的序列【分割】成两组，其中一组的值均小于另一组。
 * 2. 分别对这两组继续进行排序，使整个序列有序。
 *
 * 在分割的过程中，枢纽值的选择至关重要。
 * 本算法采取【三位取中法】，可以很大程度上避免分组"一边倒"的情况。
 *
 * 平均时间复杂度：O(nlogn)
 *
 * 三数取中：
 * 取左端、中间、右端三个数，然后进行排序，将【中间数】作为枢纽值，放在待排序列的倒数第二位。
 *
 * https://www.cnblogs.com/chengxiao/p/6262208.html
 */
public class QuickSort {
    /**
     * 快速排序
     * @param arr 待排序数组
     * @param left 待排序序列最左下标
     * @param right 待排序序列最右下标
     */
    public static void quickSort(int[] arr, int left, int right) {
        // 若只剩一个元素，则不排序直接返回
        if (left < right) {
            dealPivot(arr, left, right);
            int pivot = right - 1;
            int i = left, j = pivot;
            while (true) {
                // i位置的值>=枢纽值
                // 这里不用写i<right是因为
                // 条件限制了i最大为pivot
                while (arr[++i] < arr[pivot]);
                // j位置的值<=枢纽值
                while (j > left && arr[--j] > arr[pivot]);
                // 没碰撞：交换两个元素
                if (i < j)
                    swap(arr, i, j);
                // 碰撞：i位置之后不存在比arr[pivot]小的元素
                else
                    break;
            }
            // i<pivot说明pivot左侧还有大于arr[pivot]的值
            // 需要放到后面序列(大值)去进行排序
            // i最大为pivot
            if (i < pivot)
                swap(arr, i, pivot);
            // i位置左侧全是小于arr[pivot]的元素
            // i位置右侧全是大于arr[pivot]的元素
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }
    // 将枢纽值放在待排序的序列倒数第二位
    public static void dealPivot(int[] arr, int left, int right) {
        int mid = left/2 + right/2;
        if (arr[left] > arr[mid])
            swap(arr, left, mid);
        if (arr[left] > arr[right])
            swap(arr, left, right);
        if (arr[mid] > arr[right])
            swap(arr, mid, right);
        swap(arr, right - 1, mid);
    }
    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 9, 5, 7, 8, 1, 2, 3, 6};
        QuickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println("排序结果：" + Arrays.toString(arr));
    }
}
