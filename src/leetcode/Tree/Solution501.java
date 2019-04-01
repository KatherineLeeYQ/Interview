package leetcode.Tree;

import leetcode.TreeNode;

import java.util.*;

/**
 * 【二叉搜索树中的众数】
 */
public class Solution501 {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        TreeNode cur;
        int count;
        while (!list.isEmpty()) {
            cur = list.pop();

            count = map.getOrDefault(cur.val, 0);
            count++;
            map.put(cur.val, count);

            if (cur.left != null)
                list.add(cur.left);
            if (cur.right != null)
                list.add(cur.right);
        }

        int maxCount = -1;
        List<Integer> maxVal = new ArrayList<>();
        for (Integer val: map.keySet()) {
            if (map.get(val) > maxCount) {
                maxCount = map.get(val);
                maxVal.clear();
                maxVal.add(val);
            }
            if (map.get(val) == maxCount) {
                maxVal.add(val);
            }
        }

        return null;
    }
}
