package interview.huawei4_29;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 应该是题目一正解
 * 不重复字符串
 * 字符全排列，放入set中，输出set大小
 */
public class Main11 {
    private static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        set.add(str);
        char[] c = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            c[i] = str.charAt(i);
        }

        f(c, 0);

        System.out.println(set);
        System.out.println(set.size());

    }

    /**
     * 字符串全排列
     * @param c 字符串转换的数组
     * @param i 从i开始全排列
     */
    private static void f(char[] c, int i) {
        if (i == c.length) {
            set.add(ToString(c));
        }
        for (int j = i; j < c.length; j++) {
            //将第i位与第k位交换
            char t = c[j];
            c[j] = c[i];
            c[i] = t;

            // 移交下一层去确认k+1位
            f(c, i + 1);

            //回溯（换回来）
            t = c[j];
            c[j] = c[i];
            c[i] = t;
        }
    }


    /**
     * 将数组转换为字符串
     * @param c char类型的数组
     * @return c数组转换的字符串
     */
    private static String ToString(char[] c) {

        StringBuilder s = new StringBuilder();
        for (char value : c) {
            s.append(value);
        }
        return String.valueOf(s);
    }


}

