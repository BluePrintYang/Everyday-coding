package lanqiao.java2017a;

import java.util.HashSet;
import java.util.Set;

public class _02_9数算式 {
    static int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static int ans;

    public static void main(String[] args) {
        f(0);
        System.out.println(ans/2);
    }

    private static void f(int k) {
        if (k == 9) {
            for (int i = 1; i <= 8; i++) {
                int x1 = a2i(0, i);
                int x2 = a2i(i, 9);
                int x = x1 * x2;
                if (check(x)) ans++;
            }
        }

        for (int i = k; i < 9; i++) {
            int t = a[k];
            a[k] = a[i];
            a[i] = t;

            f(k + 1);

            t = a[k];
            a[k] = a[i];
            a[i] = t;
        }
    }

    private static boolean check(int i) {
        String s = i + "";
        if (s.length() != 9 || s.contains("0")) return false;
        Set<Character> set = new HashSet<>();
        for (int j = 0; j < s.length(); j++) {
            set.add(s.charAt(j));
        }

        return set.size() == 9;
    }

    private static int a2i(int i, int j) {
        int ans = 0;
        int p = 1;
        for (int k = j - 1; k >= i; k--) {
            ans += a[k] * p;
            p *= 10;
        }
        return ans;
    }
}
