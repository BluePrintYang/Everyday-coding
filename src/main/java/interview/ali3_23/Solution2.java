package interview.ali3_23;

import java.util.Scanner;

/**
 * 输入n,m两个整数代表n行m列
 * 下面输入n行字符串，每个字符串都包含m个字符（只含有'.','#','E','S')
 * 其中S代表起点，E代表终点，#代表无法通过
 * 从起点出发，可向左，向右，向上，向下移动一步
 * 也可按如下中心对称移动，也只算移动一步
 * X（i,j）→  X‘（n+1-i,m+1-j）
 *
 * 求从起点到终点最少需要移动几步,最大为5，如果不能到达输出-1
 *
 * 示例输入
 * 4 4
 * #S..
 * E#..
 * #...
 * ....
 * 输出
 * 4
 * 说明
 * 先中心对称到达（4，3），然后向上一步，向右一步，中心对称到达终点
 */
public class Solution2 {

    private static int m;
    private static int n;
    private static char[][] c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        int Si = 0;
        int Sj = 0;
        c = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                c[i][j] = s.charAt(j);
                if (c[i][j] == 'S') {
                    Si = i;
                    Sj = j;
                }
            }
        }


        int ans = fun(Si, Sj);

        System.out.println(ans);

    }

    public static int fun(int i, int j) {

        if (c[i][j] == 'E') return 1;
        if (c[i][j] == '#') return -1;
        fun(i + 1, j);//up
        fun(i - 1, j);//down
        fun(i, j + 1);//right
        fun(i, j - 1);//left
        fun(n + 1 - i, m + 1 - j);//中心对称

        return -1;
    }
}
