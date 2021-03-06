package jianzhioffer;

/**
 * 二叉搜索树的后序遍历序列
 * 输入一个非空整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * <p>
 * 一棵 BST ：左孩子 < 根结点 < 右孩子
 * 一棵 BST 的左子树或者右子树都是 BST
 * 后序遍历是，左右根：[3, 4, 9, 5, 12, 11, 10]，结合图再从左往右分析后序序列，分析子树，可以发现：
 * <p>
 * [3, 4, 9, 5] 10 [12, 11]
 * [3, 4] 5 [9]
 * [3] 4
 * [12] 11
 * 发现对于每一棵子树，它的根结点总是对应该子树的后序序列的最后一个数
 */
public class Solution23二叉搜索树后序遍历 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return isBTS(sequence, 0, sequence.length - 1);
    }

    public boolean isBTS(int[] a, int start, int end) {
        if (start >= end) return true;
        int root = a[end];
        int i;
        for (i = start; i < end; i++) {
            if (a[i] > root) break;
        }
        for (int j = i; j < end; j++) {
            if (a[j] < root) return false;
        }
        return isBTS(a, start, i - 1) && isBTS(a, i, end - 1);
    }
}
