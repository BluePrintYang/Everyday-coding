package interview.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 字符串的排序
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述：输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Solution27Star {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.equals("")) return list;
        char[] c = str.toCharArray();
        per(c, list, 0);
        HashSet<String> set = new HashSet<>(list);
        ArrayList<String> res = new ArrayList<>(set);
        res.sort(String::compareTo);
        return res;
    }

    private void per(char[] c, ArrayList<String> list, int i) {
        if (i == c.length) {
            String s = new String(c);
            list.add(s);
        }
        for (int j = i; j < c.length; j++) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            per(c, list, i + 1);
            temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
    }

    /**
     * 字典序法
     * 链接：https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7?answerType=1&f=discussion
     * 来源：牛客网
     * 1、从右向左找到第一个正序对（array[i] < array[i+1]，因为没有等号，所以可以完美去掉重复的排列）
     * 2、从i开始向右搜索，找到比array[i]大的字符中最小的那个，记为array[j]
     * 3、交换array[i]和array[j]
     * 4、将i后面的字符反转
     * 这就得到了字典序的下一个排列。
     * 连续使用这个方法则可从字典序最小的排列推出全部排列。
     * 时间复杂度O(n*n!)
     */
    public ArrayList<String> Permutation2(String str) {

        ArrayList<String> res = new ArrayList<String>();
        if (str.length() == 0) return res;
        char[] array = str.toCharArray();
        Arrays.sort(array);
        String s = new String(array);
        res.add(str);
        while (true) {
            s = nextString(s);
            if (!s.equals("finish")) {
                res.add(s);
            } else {
                break;
            }
        }
        return res;
    }

    public String nextString(String str) {
        char[] array = str.toCharArray();
        int length = str.length();
        int i = length - 2;
        for (; i >= 0 && array[i] >= array[i + 1]; i--) ;
        if (i == -1) return "finish";
        int j = length - 1;
        for (; j >= 0 && array[j] <= array[i]; j--) ;
        //swap i,j
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        //swap i,j
        for (int a = i + 1, b = length - 1; a < b; a++, b--) {
            tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
        }
        return new String(array);
    }


}
