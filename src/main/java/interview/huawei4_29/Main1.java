package interview.huawei4_29;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 笔试现场
 * ac70%
 * 输入字符串，不超过8个字符
 * 随机组合，求不重复字符串个数
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        int size = set.size();
        int ans = f(size)+str.length()-size;
        System.out.println(ans);
    }

    private static int f(int size) {
        if (size==1)return 1;
        return f(size-1)*size;
    }
}
