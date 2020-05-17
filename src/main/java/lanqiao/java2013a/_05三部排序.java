package lanqiao.java2013a;

import java.util.Arrays;

/**
 * 一趟快排
 */
public class _05三部排序 {
    private static void sort(int[] a) {
        int p = 0;
        int left = 0;
        int right = a.length - 1;
        while (p <= right) {
            if (a[p] < 0) {
                int t = a[p];
                a[p] = a[left];
                a[left] = t;
                left++;
                p++;
            } else if (a[p] > 0) {
                int t = a[right];
                a[right] = a[p];
                a[p] = t;
                right--;
            } else {
                //填空
                p++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {-2, 15, 0, 5, 2, -5, 5, 29};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
