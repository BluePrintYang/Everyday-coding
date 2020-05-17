package jianzhioffer;

import java.util.ArrayList;

/**
 * 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 思路：1.中序遍历，保存到list，2.修改指针
 */
public class Solution26 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null) return null;
        ArrayList<TreeNode> list = new ArrayList<>();
        mid(pRootOfTree,list);
        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).right=list.get(i+1);
            list.get(i+1).left=list.get(i);
        }
        return list.get(0);
    }

    public void mid(TreeNode node, ArrayList<TreeNode> list){
        if (node.left!=null)mid(node.left,list);
        list.add(node);
        if (node.right!=null)mid(node.right,list);
    }
}
