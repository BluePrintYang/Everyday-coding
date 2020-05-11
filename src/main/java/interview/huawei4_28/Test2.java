package interview.huawei4_28;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 给定一个字符串，输出去重后的字符串，原字符串顺序不变
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        Object[] characters = set.toArray();
        for (Object character : characters) {
            System.out.print(character);
        }
    }
}
