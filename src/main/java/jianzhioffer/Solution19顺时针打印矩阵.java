package jianzhioffer;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution19顺时针打印矩阵 {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        int[][] vis = new int[matrix.length][matrix[0].length];
        ArrayList<Integer> ans = new ArrayList<>();
        printArray(0, 0, vis, matrix,ans);
        return ans;
    }

    private static void printArray(int i, int j, int[][] vis, int[][] matrix,ArrayList<Integer> ans) {
        if (vis[i][j] == 0) {
//            System.out.print(matrix[i][j] + " ");
            ans.add(matrix[i][j]);
            vis[i][j] = 1;
            if (j + 1 < vis[0].length && vis[i][j + 1] == 0) {
                if (i - 1 >= 0 && vis[i - 1][j] == 0) printArray(i - 1, j, vis, matrix,ans);//up
                printArray(i, j + 1, vis, matrix,ans);
            }//right
            if (i + 1 < vis.length && vis[i + 1][j] == 0) printArray(i + 1, j, vis, matrix,ans);//down
            if (j - 1 >= 0 && vis[i][j - 1] == 0) printArray(i, j - 1, vis, matrix,ans);//left
            if (i - 1 >= 0 && vis[i - 1][j] == 0) printArray(i - 1, j, vis, matrix,ans);//up
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] b = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(printMatrix(b));
    }
}
