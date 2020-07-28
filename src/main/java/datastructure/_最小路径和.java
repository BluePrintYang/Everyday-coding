package datastructure;

/**
 * @Author: yangllong
 * @DATE: 2020/7/1 11:27
 */
public class _最小路径和 {
    int minPathSum(int[][] a) {
        if (a.length == 0) return 0;
        if (a[0].length == 0) return 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (i == 0 && j == 0) continue;
                int tp = Integer.MAX_VALUE;
                if (i > 0) tp = Math.min(tp, a[i - 1][j]);
                if (j > 0) tp = Math.min(tp, a[i][j - 1]);
                a[i][j] += tp;
            }
        }
        return a[a.length-1][a[0].length-1];
    }

    public static void main(String[] args) {
        _最小路径和 test = new _最小路径和();
        int[][] a = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(test.minPathSum(a));
    }
}
