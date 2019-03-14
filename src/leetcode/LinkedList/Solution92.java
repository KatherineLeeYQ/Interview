package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * 【反转链表 II】
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 1 ≤ m ≤ n ≤ 链表长度。
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;

        // m = 1的情况
        ListNode pre = null, cur = head;
        while (m > 1) {
            pre = cur;
            cur = cur.next;

            m--;
            n--;
        }
        // 此时m = 1, n = n-m+1
        ListNode tail = pre;

        ListNode begin = cur;
        ListNode tmp = null, next = cur.next;
        while (n > 1) {
            // 只要进入了循环，那么next一定非null
            // 记录下一个节点的next
            tmp = next.next;
            // 将下一个节点的next指向现在的节点（反转）
            next.next = cur;
            // 更新cur
            cur = next;
            // 更新next
            next = tmp;
            --n;
        }
        // 拼接后一段元素
        begin.next = next;

        // 拼接前一段元素
        ListNode newhead;
        if (tail != null) {
            tail.next = cur;
            newhead = head;
        }
        else {
            newhead = cur;
        }
        return newhead;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        Solution92 s = new Solution92();
        s.reverseBetween(a, 2, 4);
    }
}
