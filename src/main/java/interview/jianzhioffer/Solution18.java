package interview.jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class Solution18 {
    public void Mirror(TreeNode root) {
        /*递归解法
        if (root==null){
            return;
        }
        TreeNode t = root.left;
        root.left=root.right;
        root.right=t;
        Mirror(root.left);
        Mirror(root.right);*/
        //非递归解法
        if(root == null) return;
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode curr, temp;
        nodes.offer(root);
        while(!nodes.isEmpty()){
            int len = nodes.size();
            for(int i = 0; i < len; i++){
                curr = nodes.poll();
                temp = curr.left;
                curr.left = curr.right;
                curr.right = temp;
                if(curr.left != null) nodes.offer(curr.left);
                if(curr.right != null) nodes.offer(curr.right);
            }
        }
    }
}
