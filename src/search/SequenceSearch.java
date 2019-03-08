package search;

/**
 * 顺序查找
 * 时间复杂度：O(n)
 */
public class SequenceSearch {
    public int sequenceSearch(int[] arr, int value) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }
}
