package lanqiao.java2013a;

/**
 * 从“从”出发，只能向下和向右，走到华，有多少种走法
 * 从我做起振
 * 我做起振兴
 * 做起振兴中
 * 起振兴中华
 *
 * 递归
 */
public class _02振兴中华 {
    public static void main(String[] args) {
        //重复
        //变化
        //边界
        int ans = f(0, 0);
        System.out.println(ans);
    }

    private static int f(int i, int j) {
        if (i == 3 || j == 4) return 1;
        return f(i + 1, j) + f(i, j + 1);//将两种走法的路线数相加
    }
}
