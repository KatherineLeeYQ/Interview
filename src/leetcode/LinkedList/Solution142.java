package leetcode.LinkedList;

import leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 【环形链表 II】
 *
 * Note:
 * 1. 用一个set，遍历的过程中如果碰到重复节点，则有环，输入第一个重复的节点
 * 2. 不使用额外空间：
 *      a> 快慢指针，快指针等于慢指针
 *      b> 有环相遇时，快指针走过的路是慢指针的两倍
 *      c> 慢指针走过的路为x+y，其中y为环入口到相遇点的距离
 *      d> 而快指针走过的路为x+y+y+z，其中z为相遇点到环入口的距离
 *      e> 故z == x
 *      f> 只需要一个新指针在头结点开始，和慢指针同步走，一定在环入口相遇
 *
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head, quick = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;

            // 快指针 == 慢指针，有环
            if (quick == slow) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }

        return null;
    }
}
