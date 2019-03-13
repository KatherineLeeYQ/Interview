package leetcode;

/**
 * 【旋转链表】
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;

        // 找到链表尾节点
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            ++n;
        }
        // 形成循环链表
        tail.next = head;

        int count = 0;
        // 移动尾节点n - k % n次，即为新链表尾节点
        while (count < n - k % n) {
            tail = tail.next;
            ++count;
        }

        // 新链表头节点为尾节点的next
        ListNode newHead = tail.next;
        // 尾节点next置空
        tail.next = null;

        return newHead;
    }
}
