package leetcode.Tree;

import leetcode.TreeNode;

import java.util.*;

/**
 * 【两数之和 IV - 输入 BST】：BST 中是否存在两个元素且它们的和等于给定的目标结果
 * Note：
 * 二叉搜索树，不能存在两个同样值的节点
 * 注意判断这种情况
 */
public class Solution653 {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> valueSet = new HashSet<>();

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);

        TreeNode curNode;
        while (!list.isEmpty()) {
            curNode = list.pop();
            valueSet.add(curNode.val);

            if (curNode.left != null)
                list.add(curNode.left);
            if (curNode.right != null)
                list.add(curNode.right);
        }
        if (valueSet.size() < 2)
            return false;

        Iterator<Integer> it = valueSet.iterator();
        while (it.hasNext()) {
            int num1 = it.next();
            int num2 = k - num1;
            // 二叉搜索树，不能存在两个同样值的节点
            if (num2 != num1 && valueSet.contains(num2))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        node1.right = node2;

        Solution653 s = new Solution653();
        s.findTarget(node1, 6);
    }
}
