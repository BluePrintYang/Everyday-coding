package jianzhioffer;

import java.util.Arrays;


/**
 * 重建二叉树
 */
public class Solution4 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        // 在中序中找到前序的根
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                // 左子树，注意 copyOfRange 函数，左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                // 右子树，注意 copyOfRange 函数，左闭右开
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        /*Solution4 s = new Solution4();
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] mid = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = s.reConstructBinaryTree(pre, mid);*/
       int[] array = {1,5,7,4,8};
       int[] b = Arrays.copyOfRange(array,1,9);
       int[] cc = new int[array.length];
       System.arraycopy(array,0,cc,2,3);
       System.out.println(Arrays.toString(cc));
       System.out.println(Arrays.toString(b));
    }
}
