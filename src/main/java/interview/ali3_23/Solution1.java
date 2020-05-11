package interview.ali3_23;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 输入一个整数n 1<n<10^9
 * 输出一个整数
 *
 * 找出其所有非空子集中所有元素个数之和，然后对10^9+7取模，输出结果
 * 例如输入2，有{1}，{2}，{1，2}3个非空子集，所有元素个数之和为4
 * 输出结果为4
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        BigInteger in = BigInteger.valueOf(Long.parseLong(n));
        BigInteger num = f(in);//种数
        BigInteger x = BigInteger.valueOf(10).pow(9).add(BigInteger.valueOf(7));
        System.out.println(num);
        System.out.println(num.mod(x));
    }

    private static BigInteger f(BigInteger n) {
        return n.multiply(BigInteger.valueOf(2).pow(n.intValue()-1));
    }
}
