package leetcode;

import java.util.LinkedList;

/**
 * 【路径总和 III】:
 * 路径不需要从根节点开始，也不需要在叶子节点结束,找出路径和等于给定数值的路径总数。
 *
 * Note:
 * 注意不是路径到了一半达到了sum就返回，因为后半段路径可能和为0，这也要算进来
 *
 */
public class Solution437 {
    // root不一定在这条路径里
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        int res = rootSum(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }
    // root一定在这条路径里
    private int rootSum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        int res = 0;
        // 注意不是路径到了一半达到了sum就返回1
        // 只能给res加1，表示现在已经得到了一种路径
        // 但很有可能这条路径是另一条成功路径的一部分，所以不能返回
        if (root.val == sum)
            res += 1;
        res += rootSum(root.left, sum - root.val);
        res += rootSum(root.right, sum - root.val);

        return res;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(-3);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(11);
        TreeNode g = new TreeNode(3);
        TreeNode h = new TreeNode(-2);
        TreeNode i = new TreeNode(1);
        a.left = b;
        b.left = d;
        b.right = e;
        d.left = g;
        d.right = h;
        e.right = i;
        a.right = c;
        c.right = f;

        Solution437 s = new Solution437();
        s.pathSum(a, 8);
    }
}
