package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * 【分隔链表】
 */
public class Solution725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] list = new ListNode[k];
        ListNode head  = root, tail;

        int n = 0;
        while (root != null) {
            root = root.next;
            ++n;
        }

        // 现在组的下标
        int cur = 0;
        int per = n / k;
        // 有k组per个元素
        // 有left组per+1个元素
        int left = n - per * k;

        // 若没有生成完所有组 && 还有剩余节点没有进组
        while (cur < k && head != null) {
            int len; // 本组元素个数
            if (cur < left)
                len = per + 1;
            else
                len = per;

            // 本组头结点
            list[cur++] = head;

            // 找到本组tail
            tail = head;
            for (int j = 0; j < len - 1; j++) {
                tail = tail.next;
            }

            // 下一组头结点
            head = tail.next;
            // 本组尾节点next置空
            tail.next = null;
        }

        return list;
    }
}