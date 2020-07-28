package jianzhioffer;

/**
 * @Author: yangllong
 * @DATE: 2020/7/2 10:58
 * 剪绳子
 * 长度为n（2 <= n <= 60）的绳子，把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n）
 * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
 */
public class Solution67剪绳子 {
    public int cutRope(int target) {
        if (target == 2) return 1;
        if (target == 3) return 2;
        int[] f = new int[target + 1];
        for (int i = 1; i < 4; i++) {
            f[i] = i;
        }
        for (int i = 5; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                f[i] = Math.max(f[i], j * f[i - j]);
            }
        }
        return f[target];
    }

    public static void main(String[] args) {
        Solution67剪绳子 test = new Solution67剪绳子();
        System.out.println(test.cutRope(8));
    }
}
