package jianzhioffer;

/**
 * @Author yangllong
 * @Date 2020/5/28 23:22
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素
 * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Solution52 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = 1;
            for (int j = 0; j < A.length; j++) {
                if (j != i) B[i] *= A[j];
            }
        }
        return B;
    }
}
