package jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的深度
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Solution39 {
    //递归
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right) + 1;
    }


    //非递归写法
    public int TreeDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int d = 0, count = 0, nextcount = q.size();
        while (q.size() != 0) {
            TreeNode t = q.poll();
            count++;
            if (t.left != null) {
                q.add(t.left);
            }
            if (t.right != null) {
                q.add(t.right);
            }
            if (count == nextcount) {
                d++;
                count = 0;
                nextcount = q.size();
            }
        }
        return d;
    }
}
