package leetcode;

import java.util.Arrays;

/**
 * 2020.3.3
 * 合并排序的数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class Solution1001 {
    public static void merge(int[] A, int m, int[] B, int n) {
        System.arraycopy(A, 0, A, n, m);

        int index = 0;
        int indexA, indexB;
        for (indexA = n, indexB = 0; indexA < m + n && indexB < n; ) {
            if (A[indexA] < B[indexB]) {
                A[index] = A[indexA];
                indexA++;
            } else {
                A[index] = B[indexB];
                indexB++;
            }
            index++;
        }

        while (indexA < m + n) {
            A[index] = A[indexA];
            index++;
            indexA++;
        }

        while (indexB < n) {
            A[index] = B[indexB];
            index++;
            indexB++;
        }

    }

    public static void main(String[] args) {
        int[] A = {2, 0};
        int m = 1;
        int[] B = {1};
        int n = 1;
        System.out.println(Arrays.toString(A));
        merge(A, m, B, n);
        System.out.println(Arrays.toString(A));
        /*int[] A = {1,2,3};
        int[] B = A.clone();
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));*/
    }
}
