package interview.netease8_8;

import java.util.*;

/**
 * 5 3
 * 2 1 5
 *
 * 2 1 3 4 5
 *
 * 5 2
 * 4 2
 *
 * 1 3 4 2 5
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] T = new int[m];
        List<Integer> res = new ArrayList<>();
        List<Integer> TS = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            T[i] = sc.nextInt();
            set.add(T[i]);
        }
        int pointT = 0;
        int pointTS = 0;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i) && TS.size() < (n - m)) TS.add(i);
        }

        while (res.size() < n) {
            while (pointT < T.length && pointTS < TS.size()) {
                if (TS.get(pointTS) < T[pointT]) {
                    res.add(TS.get(pointTS));
                    pointTS++;
                } else {
                    res.add(T[pointT]);
                    pointT++;
                }
            }
            if (pointT == T.length && pointTS < TS.size()) {
                while (pointTS < TS.size()) {
                    res.add(TS.get(pointTS));
                    pointTS++;
                }
            }
            if (pointT < T.length && pointTS == TS.size()) {
                while (pointT < T.length) {
                    res.add(T[pointT]);
                    pointT++;
                }
            }
        }

        for (int i = 0; i < res.size(); i++) {
            if (i == res.size() - 1) System.out.println(res.get(i));
            else System.out.print(res.get(i) + " ");
        }
    }
}
