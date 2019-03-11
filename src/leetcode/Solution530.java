package leetcode;

import java.util.Stack;

/**
 * 【二叉搜索树的最小绝对差】
 * Note:
 * 最小绝对差只会出现在【中序遍历】相邻的两个节点之间
 */
public class Solution530 {
    public int getMinimumDifference(TreeNode root) {
        int minDifference = Integer.MAX_VALUE;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode preNode = null;
        TreeNode curNode = root;

        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            // left == null
            if (!stack.isEmpty()) {
                curNode = stack.pop();
                if (preNode != null)
                    minDifference = Math.min(minDifference, curNode.val - preNode.val);
                preNode = curNode;

                curNode = curNode.right;
            }
        }

        return minDifference;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.right = b;
        b.right = c;

        Solution530 s = new Solution530();
        s.getMinimumDifference(a);
    }
}
