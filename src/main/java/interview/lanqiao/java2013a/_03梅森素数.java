package interview.lanqiao.java2013a;

import java.math.BigInteger;

/**
 * 求2^11213 - 1 这个数字的最后一百位
 * 使用BigIntegerAPI
 */
public class _03梅森素数 {
    public static void main(String[] args) {
        BigInteger x = BigInteger.valueOf(2).pow(11213).subtract(BigInteger.ONE);
        String s = x.toString();
        int length = s.length();
        String ans = s.substring(length - 100);
        System.out.println(ans);
    }
}
