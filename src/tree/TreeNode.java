package tree;

public class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(char x) { val = x; }

    public void print() {
        System.out.print(this.val + " ");
    }
}
