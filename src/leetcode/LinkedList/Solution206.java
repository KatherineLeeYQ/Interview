package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * 【反转链表】
 *
 * Note:
 * 【反转链表2】92题
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode cur = head, next = cur.next;
        ListNode tmp;
        while (next != null) {
            // 记录下一个节点的next
            tmp = next.next;

            // 更新指向
            next.next = cur;

            // 指针后移
            cur = next;
            next = tmp;
        }
        // 这一句必须要加，否则就成了环
        head.next = null;

        return cur;
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

        Solution206 s = new Solution206();
        s.reverseList(a);
    }
}
