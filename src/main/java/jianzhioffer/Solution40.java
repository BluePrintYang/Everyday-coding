package jianzhioffer;


/**
 * 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * <p>
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 */
public class Solution40 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        if (TreeDepth(root.left) - TreeDepth(root.right) > 1 || TreeDepth(root.left) - TreeDepth(root.right) < -1)
            return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

    public static void main(String[] args) {
        System.out.println((9 * 9 + 9) >> 1);
    }
}
