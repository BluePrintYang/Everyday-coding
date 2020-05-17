package lanqiao.java2013a;

import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Collections.sort;

/**
 * n行数据，每行数据用空格隔开
 * 数据本应该是连续的，但是其中有一个重复的，另外缺少一个，假设缺少的不会出现在首尾
 * 找出重复的数和缺的数
 */
public class _07错误票据 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        sc.nextLine();//吃掉换行符
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] split = line.split(" ");

            for (String value : split) {
                list.add(Integer.parseInt(value));
            }

        }
        sort(list);
        int a = 0, b = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) == 0) a = list.get(i);
            if (list.get(i) - list.get(i - 1) == 2) b = list.get(i) - 1;
        }
        System.out.println(a + " " + b);
    }
}
