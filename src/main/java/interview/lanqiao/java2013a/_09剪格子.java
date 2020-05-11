package interview.lanqiao.java2013a;

import java.util.Scanner;

/**
 * 测试用例1：
 * 输入
 * 3 3
 * 10 1 52
 * 20 30 1
 * 1 2 3
 * 输出
 * 3
 * 测试用例2：
 * 输入
 * 4 3
 * 1 1 1 1
 * 1 30 80 2
 * 1 1 1 100
 * 输出
 * 10
 *
 * 深搜回溯剪枝
 *
 * 有问题
 * 不能解决类似下面的问题
 * 2 2
 * 1 1
 * 1 3
 */
public class _09剪格子 {

    static int[][] g;
    static int[][] vis;//标记
    private static int m;
    private static int n;
    private static int total;
    private static int ans = Integer.MAX_VALUE;

    static void dfs(int i, int j, int steps, int sum) {

        if (i < 0 || i == n || j < 0 || j == m || vis[i][j] == 1) return;//走出边界或该点已走过，非法路径

        if (sum == total / 2) {
            ans = Integer.min(ans, steps);
            return;
        }

        if (sum > total / 2) return;
        vis[i][j] = 1;
        dfs(i - 1, j, steps + 1, sum + g[i][j]);//up
        dfs(i + 1, j, steps + 1, sum + g[i][j]);//down
        dfs(i, j - 1, steps + 1, sum + g[i][j]);//left
        dfs(i, j + 1, steps + 1, sum + g[i][j]);//right
        vis[i][j] = 0;
    }

    public static void main(String[] args) {
        //读入两个数字m,n用空格分开
        //表示表格宽度和高度
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        g = new int[n][m];
        vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = sc.nextInt();
                total += g[i][j];
            }
        }
        //完成输入
        dfs(0, 0, 0, 0);

        System.out.println(ans);
    }
}
