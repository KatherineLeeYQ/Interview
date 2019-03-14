package leetcode.Array;

/**
 * 【按奇偶排序数组】
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 *
 * Point:
 * 	一个数组A，存放着奇数和偶数。
 * 	一个基本数组int[] a = new int[len];
 * 	a前部放A中的偶数，后部放A中的奇数。
 *
 * Note:
 * 在一遍遍历过程中完成
 * 不要去使用先找出偶数再找奇数，然后再拼凑的做法。
 */
public class Solution905 {
    public int[] sortArrayByParity(int[] A) {
        int count = A.length;
        int[] res = new int[count];

        int odd = 0;
        int even = count - 1;
        int num;
        for (int i = 0; i < count; ++i) {
            num = A[i];
            if (num % 2 == 0) {
                res[odd] = A[i];
                ++odd;
            } else {
                res[even] = A[i];
                --even;
            }
        }

        return res;
    }
}
