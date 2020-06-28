package jianzhioffer;

/**
 * @Author yangllong
 * @Date 2020/5/28 23:35
 * 正则表达式匹配
 * 字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Solution53 {
    public boolean match(char[] str, char[] pattern) {
        if (pattern.length == 0 && str.length != 0) return false;
        int sp = 0;
        int pp = 0;
        while (sp < str.length) {
            //当前字符相同
            if (str[sp] == pattern[pp]) {
                //pattern下一个字符不为‘*’
                if (pp + 1 < pattern.length && pattern[pp + 1]!='*') {
                    sp++;
                    pp++;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "1e2";
        System.out.println(Integer.valueOf(str));
    }
}
