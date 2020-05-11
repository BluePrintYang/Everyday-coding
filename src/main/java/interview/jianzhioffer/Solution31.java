package interview.jianzhioffer;

/**
 * 整数中1出现的次数
 * 从1 到 n 中1出现的次数
 */
public class Solution31 {
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        int temp;
        for (int i = 1; i <= n; i++) {
            temp = i;
            while (temp != 0) {
                if (temp % 10 == 1) count++;
                temp /= 10;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = NumberOf1Between1AndN_Solution(99);
        System.out.println(n);
    }
}
