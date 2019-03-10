package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution530 {
    public int getMinimumDifference(TreeNode root) {
        Set<Integer> valueSet = new HashSet<>();

        valueSet.add(root.val);
        if (root.left != null) {
            TreeNode left = root.left;
            TreeNode tmp = left.left;
        }

        return 0;
    }
}
