package leetcode.LinkedList;

import leetcode.ListNode;

public class Solution147 {
    // 超过内存限制？？？？？
    public ListNode insertionSortList1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = head;
        ListNode cur = newHead.next, next;
        newHead.next = null;

        ListNode pre = null, suf;
        while (cur != null) {
            next = cur.next;

            suf = newHead;
            while (suf != null && cur.val > suf.val) {
                pre = suf;
                suf = suf.next;
            }
            if (pre == null)
                newHead = cur;
            else
                pre.next = cur;
            cur.next = suf;

            cur = next;
        }

        return newHead;
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 使用一个新生成的头结点，避免很多问题
        ListNode dummy = new ListNode(0);
        ListNode cur = head, next;

        // 寻找当前节点的插入位置
        ListNode pre, suf;
        while (cur != null) {
            next = cur.next;

            pre = dummy;
            suf = dummy.next;
            while (suf != null && cur.val > suf.val) {
                pre = suf;
                suf = suf.next;
            }
            pre.next = cur;
            cur.next = suf;

            cur = next;
        }

        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(-1);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(0);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        Solution147 s = new Solution147();
        s.insertionSortList(a);
    }
}
