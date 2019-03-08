package tree;

/**
 * 【二叉平衡树】
 * https://baijiahao.baidu.com/s?id=1577200621749785094&wfr=spider&for=pc
 */
public class BalancedBinarySearchTree {
    TreeNode root;

    // 获取节点的深度
    public static int nodeHeight(TreeNode node) {
        int heightLeft = 0;
        int heightRight = 0;

        if (node.left != null)
            heightLeft = nodeHeight(node.left);
        if (node.right != null)
            heightRight = nodeHeight(node.right);

        return Math.max(heightLeft, heightRight) + 1;
    }

    // 获取节点的平衡因子
    public static int balanceFactor(TreeNode node) {
        int bf = 0;
        if (node.left != null)
            bf += nodeHeight(node.left);
        if (node.right != null)
            bf -= nodeHeight(node.right);
        return bf;
    }

    // 右旋
    public static void rightRotate(TreeNode node) {
        TreeNode a = node;
        TreeNode b = node.left;

        a.left = b.right;
        b.right = a;
    }

    // 左右旋
    public static void leftRightRotate(TreeNode node) {
        TreeNode a = node;
        TreeNode b = a.left;
        TreeNode c = b.right;

        // 左旋
        b.right = c.left;
        c.left = b;

        // 右旋
        a.left = c.right;
        c.right = a;
    }

    // 左旋
    public static void leftRotate(TreeNode node) {
        TreeNode a = node;
        TreeNode b = a.right;

        a.right = b.left;
        b.left = a;
    }

    // 右左旋
    public static void rightLeftRotate(TreeNode node) {
        TreeNode a = node;
        TreeNode b = a.right;
        TreeNode c = b.left;

        // 右旋
        b.left = c.right;
        c.right = b;

        // 左旋
        a.right = c.left;
        c.left = a;
    }

    /**
     * 【伪代码】：
     * IF 平衡因子 >= 2
     *      IF 左节点平衡因子 < 0
     *          左右旋
     *      ELSE
     *          右旋
     * ELSE IF 平衡因子 <= -2
     *      IF 右节点平衡因子 > 0
     *          右左旋
     *      ELSE
     *          左旋
     * ELSE
     *      平衡
     */

    public static void balanceNode(TreeNode node) {
        if (node.left != null)
            balanceNode(node.left);
        if (node.right != null)
            balanceNode(node.right);

        int bf = balanceFactor(node);
        if (bf >= 2) {
            // 肯定有左节点
            if (balanceFactor(node.left) <= -1)
                leftRightRotate(node);
            else
                rightRotate(node);
        }
        else if (bf <= -2) {
            // 肯定有右节点
            if (balanceFactor(node.right) >= 1)
                rightLeftRotate(node);
            else
                leftRotate(node);
        }
    }
}
