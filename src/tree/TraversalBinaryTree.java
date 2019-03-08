package tree;

/**
 * 非递归遍历二叉树
 * https://www.cnblogs.com/zl1991/p/6952587.html
 */
public class TraversalBinaryTree {
    /**
     * 根据先序遍历的顺序，先访问根节点，再访问左子树，后访问右子树，而对于每个子树来说，又按照同样的访问顺序进行遍历。
     *
     * 非递归的实现思路如下，对于任一节点P：
     *
     * 1）输出节点P，然后将其入栈，再看P的左孩子是否为空；
     *
     * 2）若P的左孩子不为空，则置P的左孩子为当前节点，重复1）的操作；
     *
     * 3）若P的左孩子为空，则将栈顶节点出栈，但不输出，并将出栈节点的右孩子置为当前节点，看其是否为空；
     *
     * 4）若不为空，则循环至1）操作；
     *
     * 5）如果为空，则继续出栈，但不输出，同时将出栈节点的右孩子置为当前节点，看其是否为空，重复4）和5）操作；
     *
     * 6）直到当前节点P为NULL并且栈空，遍历结束。
     *
     */
    public static void preoderTraversal(TreeNode node) {

    }

    /**
     * 根据中序遍历的顺序，先访问左子树，再访问根节点，后访问右子树，而对于每个子树来说，又按照同样的访问顺序进行遍历。
     *
     * 非递归的实现思路如下，对于任一节点P：
     *
     * 1）若P的左孩子不为空，则将P入栈并将P的左孩子置为当前节点，然后再对当前节点进行相同的处理；
     *
     * 2）若P的左孩子为空，则输出P节点，而后将P的右孩子置为当前节点，看其是否为空；
     *
     * 3）若不为空，则重复1）和2）的操作；
     *
     * 4）若为空，则执行出栈操作，输出栈顶节点，并将出栈的节点的右孩子置为当前节点，看起是否为空，重复3）和4）的操作；
     *
     * 5）直到当前节点P为NULL并且栈为空，则遍历结束。
     */
    public static void inoderTraversal(TreeNode node) {

    }

    /**
     * 根据后序遍历的顺序，先访问左子树，再访问右子树，后访问根节点，而对于每个子树来说，又按照同样的访问顺序进行遍历。
     * 后序遍历的非递归的实现相对来说要难一些，要保证根节点在左子树和右子树被访问后才能访问。
     *
     * 思路如下，对于任一节点P：
     *
     * 1）先将节点P入栈；
     *
     * 2）若P不存在左孩子和右孩子，或者P存在左孩子或右孩子，但左右孩子已经被输出，则可以直接输出节点P，并将其出栈，将出栈节点P标记为上一个输出的节点，再将此时的栈顶结点设为当前节点；
     *
     * 3）若不满足2）中的条件，则将P的右孩子和左孩子依次入栈，当前节点重新置为栈顶结点，之后重复操作2）；
     *
     * 4）直到栈空，遍历结束。
     *
     */
    public static void postoderTraversal(TreeNode node) {

    }
}
