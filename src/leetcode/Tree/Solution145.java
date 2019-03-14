package leetcode.Tree;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 【二叉树的后序遍历】
 *
 * Note:
 * 利用一个栈和两个指针
 *
 */
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return Arrays.asList();

        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode cur, pre = null;
        while (!stack.isEmpty()) {
            cur = stack.peek();

            // 1. 左右节点都为空，直接输出
            // 2. 至少存在一个左右孩子，且左右孩子已经输出了，那么本节点直接输出
            if ((cur.left == null && cur.right == null) ||
                    (pre != null && (cur.left == pre || cur.right == pre))) {
                list.add(cur.val);
                pre = cur;
                stack.pop();
            }
            else {
                // 先放右节点，再放左节点
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
        }

        return list;
    }
}
