package leetcode;

import java.util.Stack;

/**
 * 【二叉搜索树迭代器】
 * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度
 *
 * Note:
 * stack只保存左孩子，当最左的孩子出列时，如果它有右孩子，就把它右孩子以及往下的所有左节点压入栈
 */
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        this.addElements(root);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode cur = stack.peek().right;
        TreeNode ret = stack.pop();
        this.addElements(cur);
        return ret.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void addElements(TreeNode node) {
        while (node != null) {
            stack.push(node);

            if (node.left != null)
                node = node.left;
            else
                break;
        }
    }
}
public class Solution173 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(7);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(15);
        TreeNode d = new TreeNode(9);
        TreeNode e = new TreeNode(20);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        BSTIterator iterator = new BSTIterator(a);
        System.out.println(iterator.next());    // 返回 3
        System.out.println(iterator.next());    // 返回 7
        iterator.hasNext(); // 返回 true
        System.out.println(iterator.next());    // 返回 9
        iterator.hasNext(); // 返回 true
        System.out.println(iterator.next());    // 返回 15
        iterator.hasNext(); // 返回 true
        System.out.println(iterator.next());    // 返回 20
        iterator.hasNext(); // 返回 false
    }
}
