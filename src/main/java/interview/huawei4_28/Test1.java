package interview.huawei4_28;

import java.util.Scanner;
/**
 * 计算a+b的和
 * 每行包括a b两个数字，对应每行输入输出一行a+b的和
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            int a = s.nextInt();
            int b = s.nextInt();
            System.out.println(a + b);
        }
    }
}
