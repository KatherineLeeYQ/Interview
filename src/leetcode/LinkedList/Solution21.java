package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * 【合并两个有序链表】
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = l1.val < l2.val ? l1 : l2;

        ListNode curL1 = l1 == head ? l1.next : l1;
        ListNode curL2 = l2 == head ? l2.next : l2;
        ListNode cur = head;
        while (curL1 != null && curL2 != null) {
            if (curL1.val < curL2.val) {
                cur.next = curL1;
                cur = curL1;
                curL1 = curL1.next;
            }
            else {
                cur.next = curL2;
                cur = curL2;
                curL2 = curL2.next;
            }
        }
        while (curL1 != null) {
            cur.next = curL1;
            cur = curL1;
            curL1 = curL1.next;
        }
        while (curL2 != null) {
            cur.next = curL2;
            cur = curL2;
            curL2 = curL2.next;
        }

        return head;
    }
}
