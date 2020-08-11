package interview.netease8_8;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 3
 * 1 1 1
 *
 * 0
 *
 * 3
 * 5 3 7
 * <p>
 * 6
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger count = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x == 2 || x == 3) {
                count = count.add(BigInteger.ONE);
            } else if (x > 3) {
                int num = x / 2;
                count = count.add(BigInteger.valueOf(num));
            }
        }
        System.out.println(count);
    }

}