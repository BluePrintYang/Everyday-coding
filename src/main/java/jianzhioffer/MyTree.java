package jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author yangllong
 * @Date 2020/6/22 10:51
 */
public class MyTree {
    static List<Integer> pre = new ArrayList<>();
    static List<Integer> in = new ArrayList<>();
    static List<Integer> post = new ArrayList<>();

    //先序遍历递归写法
    public static List<Integer> PreOrder(TreeNode root) {
        if (root == null) return pre;
        pre.add(root.val);
        PreOrder(root.left);
        PreOrder(root.right);
        return pre;
    }

    //先序遍历迭代写法，使用栈，右孩子先入栈
    public static List<Integer> Pre(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return res;
    }

    //中序遍历递归写法
    public static List<Integer> InOrder(TreeNode root) {
        if (root == null) return in;
        InOrder(root.left);
        in.add(root.val);
        InOrder(root.right);
        return in;
    }

    //中序遍历迭代写法
    public static List<Integer> In(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            res.add(root.val);
            root=root.right;
        }
        return res;
    }


    //后序遍历递归写法
    public static List<Integer> PostOrder(TreeNode root) {
        if (root == null) return post;
        PostOrder(root.left);
        PostOrder(root.right);
        post.add(root.val);
        return post;
    }

    //后序遍历迭代写法
    public static List<Integer> Post(TreeNode root){
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        System.out.println(PreOrder(root));
        System.out.println(Pre(root));
        System.out.println(InOrder(root));
        System.out.println(In(root));
        System.out.println(PostOrder(root));
        System.out.println(Post(root));
    }
}
