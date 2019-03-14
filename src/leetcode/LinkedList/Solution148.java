package leetcode.LinkedList;

import leetcode.ListNode;

/**
 * 【排序链表】
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * Note：
 * while (suf != null && cur.val > suf.val)
 * 不能写成
 * while (cur.val > suf.val && suf != null)
 * 否则会出现空指针异常
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        return head == null ? null : sort(head);
    }
    private ListNode sort(ListNode head) {
        if (head.next == null)
            return head;

        // 快慢指针找中间节点
        ListNode p = head, q = head;
        ListNode pre = null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;

        ListNode l = sort(head);
        ListNode r = sort(p);
        return merge(l, r);
    }
    private ListNode merge(ListNode l, ListNode r) {
        if (l == null) return r;
        if (r == null) return l;

        ListNode head = l.val < r.val ? l : r, cur = head;
        ListNode pL = head == l ? l.next : l;
        ListNode pR = head == r ? r.next : r;
        while (pL != null && pR != null) {
            if (pL.val < pR.val) {
                cur.next = pL;
                cur = pL;
                pL = pL.next;
            }
            else {
                cur.next = pR;
                cur = pR;
                pR = pR.next;
            }
        }
        if (pL != null) {
            cur.next = pL;
        }
        if (pR != null) {
            cur.next = pR;
        }

        return head;
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

        Solution148 s = new Solution148();
        s.sortList(a);
    }
}
