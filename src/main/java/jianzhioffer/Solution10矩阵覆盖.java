package jianzhioffer;

/**
 * 矩阵覆盖
 * 斐波那契数列
 */
public class Solution10矩阵覆盖 {
    public int RectCover(int target) {
        if (target <= 2) return target;

        //迭代
        int n1 = 1;
        int n2 = 2;
        for(int i = 3 ; i<=target;i++){
            n2 += n1;
            n1 = n2 - n1;
        }
        return n2;

//        递归
//        return RectCover(target - 1) + RectCover(target - 2);
    }
}
