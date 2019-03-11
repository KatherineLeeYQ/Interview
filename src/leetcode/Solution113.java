package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【路径总和 II】
 */
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        path(res, Arrays.asList(), root, sum);

        return res;
    }
    private void path(List<List<Integer>> cur, List<Integer> tmp, TreeNode node, int target) {
        if (node == null)
            return;

        List<Integer> newList = new ArrayList<>(tmp);
        newList.add(node.val);
        if (node.val == target && node.left == null && node.right == null) {
            cur.add(newList);
            return;
        }
        else {
            path(cur, newList, node.left,target - node.val);
            path(cur, newList, node.right,target - node.val);
        }
    }

    public static void main(String[] args) {
//        TreeNode a = new TreeNode(5);
//        TreeNode b = new TreeNode(4);
//        TreeNode c = new TreeNode(8);
//        TreeNode d = new TreeNode(11);
//        TreeNode e = new TreeNode(13);
//        TreeNode f = new TreeNode(4);
//        TreeNode g = new TreeNode(7);
//        TreeNode h = new TreeNode(2);
//        TreeNode i = new TreeNode(5);
//        TreeNode j = new TreeNode(1);
//        a.left = b;
//        b.left = d;
//        d.left = g;
//        d.right = h;
//        a.right = c;
//        c.left = e;
//        c.right = f;
//        f.left = i;
//        f.right = j;
        TreeNode a = new TreeNode(1);

        Solution113 s = new Solution113();
//        s.pathSum(a, 22);
        s.pathSum(a, 1);
    }
}
