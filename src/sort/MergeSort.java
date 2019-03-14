package sort;

/**
 * 【归并排序】：（MERGE-SORT）利用归并的思想实现的排序方法，稳定排序
 * 该算法采用经典的分治（divide-and-conquer）策略
 *
 * 分治法:
 * 1. 将问题分(divide)成一些小的问题然后递归求解
 * 2. 治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之
 *
 * 归并排序我们采用递归去实现（也可采用迭代的方式去实现）：
 * 1. 分阶段，可以理解为就是递归【拆分】子序列的过程，递归深度为log2n
 * 2. 治阶段，我们需要将两个已经有序的子序列【合并】成一个有序序列，时间复杂度为O(n)
 * 平均时间复杂度：O(nlogn)
 *
 * Java中Arrays.sort()采用了一种名为TimSort的排序算法，就是归并排序的优化版本。
 *
 * 如果排序的不是数组而是链表的话，用快慢指针找中间节点：见leetcode148题
 *
 */
public class MergeSort {
    public static void mergeSort(int[]arr) {
        // 在排序前，先建一个长度等于原数组长度的临时数组，避免递归中频繁地开辟空间
        int[] tmp = new int[arr.length];
        // 排序
        sort(arr, 0, arr.length - 1, tmp);
    }
    public static void sort(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = left/2 + right/2;
            // 左序列归并排序，使有序
            sort(arr, left, mid, tmp);
            // 右序列归并排序，使有序
            sort(arr, mid + 1, right, tmp);
            // 将左右两个序列合并
            merge(arr, left, mid, right, tmp);
        }
    }
    public static void merge(int[] arr, int left, int mid, int right, int[] tmp) {
        // 左序列指针， 右序列指针
        int i = left, j = mid + 1;
        // tmp指针
        int p = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j])
                tmp[p++] = arr[i++];
            else
                tmp[p++] = arr[j++];
        }
        // 处理两个序列中的剩余元素
        while (i <= mid) {
            tmp[p++] = arr[i++];
        }
        while (j <= right) {
            tmp[p++] = arr[j++];
        }

        // 将tmp中的元素全拷贝到原数组中
        p = 0;
        while (p <= right) {
            arr[left++] = tmp[p++];
        }
    }
}
