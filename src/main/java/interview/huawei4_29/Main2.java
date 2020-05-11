package interview.huawei4_29;

import java.util.Scanner;

/**
 * 第一行输入一个字符串M（只包含小写英文字母）100000>=M.len>k
 * 第二行输入一个数字k，代表从字符串中移除k位
 * 输出移除k位后的字典序最小字符串
 * 字符串长度始终保证大于k
 * ac
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int k = s.nextInt();

        while (k>0){
            int i = judge(str);
            str=change(i,str);
            k--;
        }

        System.out.println(str);
    }

    /**
     * 去除索引为i的字符
     * @param i 索引
     * @param str 原字符串
     * @return 去除索引为i后的新字符串
     */
    private static String change(int i, String str) {
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            if (j==i) continue;
            s.append(str.charAt(j));
        }
        return String.valueOf(s);
    }

    /**
     * 从前往后依次比较，如果该字符比其后面字符在字典排序更靠后，则返回其索引
     * @param str 传入的字符串
     * @return 第一个字典排序比其后面字符更靠后的字符的索引
     */
    private static int judge(String str) {
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i-1)>str.charAt(i))return i-1;
        }
        return 0;
    }
}