package tree;

import java.util.*;

/**
 * 非递归遍历二叉树
 * https://www.cnblogs.com/zl1991/p/6952587.html
 */
public class TraversalBinaryTree {
    /**
     * 根据先序遍历的顺序，先访问根节点，再访问左子树，后访问右子树，而对于每个子树来说，又按照同样的访问顺序进行遍历。
     *
     * 非递归的实现思路如下，对于任一节点p：
     *
     * 1) 将p设置为当前节点，go 2
     * 2) 当前节点，入栈，【输出】
     * 3) 将其left设置为当前节点，go 4
     * 4) 当前节点不为null；真 -> go 2，假 -> go 5
     * 5) 栈不空，出栈一个节点q，将其right设置为当前节点
     * 6) 当前节点不为null；真 -> go 2，假 -> go 5
     * 7) 当前节点为null，遍历结束
     *
     */
    public static void preoderTraversal(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curNode = node;
        while (curNode != null) {
            stack.push(curNode);
            curNode.print(); // 在这里输出

            curNode = curNode.left;
            while (curNode == null && !stack.isEmpty()) {
                curNode = stack.pop().right;
            }
        }
    }

    /**
     * 根据中序遍历的顺序，先访问左子树，再访问根节点，后访问右子树，而对于每个子树来说，又按照同样的访问顺序进行遍历。
     *
     * 非递归的实现思路如下，对于任一节点p：
     *
     * 1) 将p设置为当前节点，go 2
     * 2) 当前节点不为空，入栈
     * 3) 将left设置为当前节点，go 4
     * 4) 当前节点不为null；真 -> go 2，假 -> go 5
     * 5) 栈不空，出栈一个节点q，【输出】，将其right设置为当前节点
     * 6) 当前节点不为null；真 -> go 2，假 -> go 5
     * 7) 当前节点为null，遍历结束
     */
    public static void inoderTraversal(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curNode = node;
        while (curNode != null) {
            stack.push(curNode);

            curNode = curNode.left;
            while (curNode == null && !stack.isEmpty()) {
                curNode = stack.pop();
                curNode.print(); // 在这里输出

                curNode = curNode.right;
            }
        }
    }

    /**
     * 根据后序遍历的顺序，先访问左子树，再访问右子树，后访问根节点，而对于每个子树来说，又按照同样的访问顺序进行遍历。
     * 后序遍历的非递归的实现相对来说要难一些，要保证根节点在左子树和右子树被访问后才能访问。
     *
     * 非递归的实现思路如下，对于任一节点P：
     *
     * 1) 将节点P入栈；
     * 2) 获取（不弹栈）栈顶节点，设置为当前节点
     * 3) 若P不存在左孩子和右孩子，或者P存在左孩子或右孩子，但左右孩子已经被输出；真 -> go 4；假 -> go 5
     * 4) 直接输出节点P，并将其出栈，将出栈节点P标记为上一个输出的节点
     * 5) 将P的右孩子和左孩子依次入栈，go 2
     * 6) 栈空，遍历结束。
     *
     */
    public static void postoderTraversal(TreeNode node) {
        if (node == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        TreeNode preNode = null; // 上一个输出的节点
        TreeNode curNode;        // 栈顶节点

        while (!stack.isEmpty()) {
            // 获取栈顶节点，但不弹栈
            curNode = stack.peek();

            // 左右节点都为空，输出
            // 左右节点已经输出过了，输出
            if ((curNode.left == null && curNode.right == null) ||
                    (preNode != null && (curNode.left == preNode || curNode.right == preNode))) {
                curNode.print();
                stack.pop();
                preNode = curNode;
            }
            // 左右节点存在且没输出过
            else {
                // 先存右节点
                if (curNode.right != null)
                    stack.push(curNode.right);
                // 再存左节点
                if (curNode.left != null)
                    stack.push(curNode.left);
            }
        }
    }

    /**
     * 层次遍历
     *
     * 实现思路如下：
     * 1) 对于节点p，将其加入队列
     * 2) 队列不为空，go 3
     * 3) 弹出队列第一个元素作为当前节点，输出，go 4
     * 4) 若当前节点有左节点，加入队列，go 5
     * 5) 若当前节点有右节点，加入队列，go 2
     * 6) 队列为空，结束遍历
     *
     */
    public static void levelTraversal(TreeNode node) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        TreeNode curNode;
        while (!queue.isEmpty()) {
            curNode = queue.pop();
            curNode.print();

            if (curNode.left != null)
                queue.add(curNode.left);
            if (curNode.right != null)
                queue.add(curNode.right);
        }
    }

    /**
     * 【习题】
     * 输入一棵二叉搜索树，将该二叉搜索树转换为一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中指针的指向。
     *
     * 分析：
     * 由于是二叉搜索树，所以排序的需求按二叉树的【中序遍历】就可以实现。
     * 转变的过程就是节点的left指向左子树的最大值，right指向右子树的最小值。
     *
     */
    public static TreeNode Convert(TreeNode root) {
        if (root == null) return null;

        TreeNode listHead;
        if (root.left != null) {
            TreeNode head = Convert(root.left);
            listHead = head;

            TreeNode tail = head;
            while (tail.right != null) {
                tail = tail.right;
            }

            root.left = tail;
            tail.right = root;
        }
        else {
            listHead = root;
        }
        if (root.right != null) {
            TreeNode head = Convert(root.right);
            root.right = head;
            head.left = root;
        }

        return listHead;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;

        System.out.println("\n先序遍历：");
        TraversalBinaryTree.preoderTraversal(a);

        System.out.println("\n中序遍历：");
        TraversalBinaryTree.inoderTraversal(a);

        System.out.println("\n后序遍历：");
        TraversalBinaryTree.postoderTraversal(a);

        System.out.println("\n层次遍历：");
        TraversalBinaryTree.levelTraversal(a);

        System.out.println("\n改链表：");
        TreeNode list = TraversalBinaryTree.Convert(a);
        while (list != null) {
            list.print();
            list = list.right;
        }
    }
}
