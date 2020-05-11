package interview.lanqiao.java2018a;

import java.math.BigInteger;

/**
 * 1 + 1/2 + 1/4 + …… + 1/2^19
 * 计算结果
 */
public class _01分数 {
    public static void main(String[] args) {
        BigInteger two = BigInteger.valueOf(2);
        BigInteger a = two.pow(20).subtract(BigInteger.ONE);
        BigInteger b = two.pow(19);
        BigInteger gcb = a.gcd(b);
        System.out.println(gcb);
        System.out.println(a + "/" + b);
    }
}
