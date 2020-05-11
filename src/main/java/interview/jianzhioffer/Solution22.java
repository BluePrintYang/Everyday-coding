package interview.jianzhioffer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 利用队列先进先出的性质
 */
public class Solution22 {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root==null)return list;

        TreeNode cur = root;
        queue.offer(cur);
        while (!queue.isEmpty()){
            cur=queue.poll();
            list.add(cur.val);
            if (cur.left!=null)queue.offer(cur.left);
            if (cur.right!=null)queue.offer(cur.right);
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        t.left.right = new TreeNode(5);
        t.right.left = new TreeNode(6);
        t.right.right = new TreeNode(7);
        System.out.println(PrintFromTopToBottom(t));
    }


}
