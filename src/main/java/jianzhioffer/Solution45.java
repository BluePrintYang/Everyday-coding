package jianzhioffer;

/**
 * 翻转单词顺序列
 * 例:student. a am I  -> I am a student.
 */
public class Solution45 {
    public static String ReverseSentence(String str) {
        if (str.length() == 0 || str.trim().equals("")) return str;
        String[] strings = str.split(" ");
        for (int i = 0; i < strings.length / 2; i++) {
            String temp = strings[i];
            strings[i] = strings[strings.length - 1 - i];
            strings[strings.length - 1 - i] = temp;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (i == strings.length - 1) ans.append(strings[i]);
            else ans.append(strings[i]).append(" ");
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(ReverseSentence("I am a student."));
    }
}
