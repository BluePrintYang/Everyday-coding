package jianzhioffer;

/**
 * 左旋转字符串
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出
 * 例:字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
 */
public class Solution43左旋转字符串 {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.equals("") || n <= 0 || n >= str.length()) return str;
        /*StringBuilder ans = new StringBuilder();
        for (int i = n; i < str.length(); i++) {
            ans.append(str.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            ans.append(str.charAt(i));
        }*/
        return str.substring(n) + str.substring(0, n);
    }
}
