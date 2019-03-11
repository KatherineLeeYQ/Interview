package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 【二叉树的中序遍历】
 *
 * Note:
 * 与144题中序遍历只有节点的输出时间不一样，其他逻辑完全一样
 *
 * 后序遍历145题
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);

            cur = cur.left;
            while (cur == null && !stack.isEmpty()) {
                cur = stack.pop();
                list.add(cur.val); // 在这里输出

                cur = cur.right;
            }
        }

        return list;
    }
}
