package leetcode;


/**
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        return "";
    }
    public static void main(String[] args) {
        String s = "abcd";
        StringBuilder s2 = new StringBuilder(s);
        StringBuilder ss = new StringBuilder(s2);
        StringBuilder rs = new StringBuilder(ss.reverse());
        System.out.println(s);
        System.out.println(s2);
        System.out.println(rs);

    }

}
