package datastructure;

import java.math.BigInteger;

/**
 * @Author: yangllong
 * @DATE: 2020/7/1 10:40
 * 三步台阶
 */
public class _三步台阶 {
    int waysToStep(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        BigInteger f0 = BigInteger.valueOf(1);
        BigInteger f1 = BigInteger.valueOf(1);
        BigInteger ans = BigInteger.valueOf(2);
        BigInteger mod = BigInteger.valueOf(1000000007);
        for (int i = 3; i <= n; i++) {
            BigInteger temp = ans;
            ans = (f0.add(f1).add(ans)).mod(mod);
            f0 = f1;
            f1 = temp;
        }
        return Integer.parseInt(ans.toString());
    }

    public static void main(String[] args) {
        _三步台阶 s = new _三步台阶();
        System.out.println(s.waysToStep(5));
        System.out.println(s.waysToStep(16213124));
    }
}
