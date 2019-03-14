package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * 【环形链表】
 *
 * Note:
 * 快慢指针，快指针等于慢指针即为有环
 *
 * 环形链表 II：142题
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode quick = head, slow = head;
        while (quick.next != null && quick.next.next != null) {
            quick = quick.next.next;
            slow = slow.next;

            // 快指针 == 慢指针，证明有环
            if (quick == slow)
                return true;
        }

        // 无环
        return false;
    }
}
