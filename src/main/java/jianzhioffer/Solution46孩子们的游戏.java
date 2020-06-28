package jianzhioffer;


/**
 * 孩子们的游戏
 * 使用数组来模拟，出列的小朋友标为-2，用vis记录已出列数目，
 * vis为n-1时判断最后剩下的小朋友是否会报数m-1，若是则返回-1，否则输出数组中唯一的非-2的数字
 */
public class Solution46孩子们的游戏 {
    public static int LastRemaining_Solution(int n, int m) {
        int vis = 0;
        int[] children = new int[n];
        for (int i = 0; i < n; i++) {
            children[i] = i;
        }
        int p = 0;
        int j = 0;
        while (vis < n - 1) {
            if (p == m - 1) {
                children[j % n] = -2;
                vis++;
                p = 0;
            } else {
                p++;
            }
            j++;
            while (children[j % n] == -2) j++;
        }
        if (p == m - 1) return -1;
        for (int i = 0; i < n; i++) {
            if (children[i] != -2) return children[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5, 2));
    }
}
