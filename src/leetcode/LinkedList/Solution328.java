package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * 【奇偶链表】
 */
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode even = head, evenTail = even;
        ListNode odd = even.next, oddTail = odd;
        if (odd == null)
            return even;

        boolean isEven = true;
        head = head.next.next;
        while (head != null) {
            if (isEven) {
                evenTail.next = head;
                evenTail = evenTail.next;
            }
            else {
                oddTail.next = head;
                oddTail = oddTail.next;
            }

            head = head.next;
            isEven = !isEven;
        }

        evenTail.next = odd;
        oddTail.next = null;
        return even;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        Solution328 s = new Solution328();
        s.oddEvenList(a);
    }
}
