package interview.huawei4_28;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 给定一个字符串，输出去重后的字符串，原字符串顺序不变
 */
public class Test2 {
    public static void main(String[] args) {
       /* Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        Object[] characters = set.toArray();
        for (Object character : characters) {
            System.out.print(character);
        }*/
        System.out.println(delRepeat("ababebfdfgh"));
    }

    public static String delRepeat(String s) {
        StringBuilder str = new StringBuilder();
        str.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (judge(s.charAt(i), str)) str.append(s.charAt(i));
        }
        return String.valueOf(str);
    }

    private static boolean judge(char c, StringBuilder str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==c)return false;
        }
        return true;
    }
}
