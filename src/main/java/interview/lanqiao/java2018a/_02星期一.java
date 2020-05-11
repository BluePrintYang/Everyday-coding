package interview.lanqiao.java2018a;

/**
 * 20世纪有几个星期一
 */
public class _02星期一 {
    public static void main(String[] args) {
        int t = 0;
        for (int i = 1901; i <= 2000; i++) {
            if (isLeap(i)) t += 366;
            else t += 365;
        }
        t -= 6;
        int ans = 0;
        for (; t > 0; t -= 7) {
            ans++;
        }
        System.out.println(ans);
    }

    private static boolean isLeap(int i) {
        return i % 400 == 0 || (i % 4 == 0 && i % 100 != 0);
    }
}
