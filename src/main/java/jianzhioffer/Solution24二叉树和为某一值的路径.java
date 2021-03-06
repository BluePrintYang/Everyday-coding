package jianzhioffer;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 * <p>
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Solution24二叉树和为某一值的路径 {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root==null)return result;
        list.add(root.val);
        target-=root.val;
        if(target==0&&root.left==null&&root.right==null)result.add(new ArrayList<>(list));
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return result;
    }
}
