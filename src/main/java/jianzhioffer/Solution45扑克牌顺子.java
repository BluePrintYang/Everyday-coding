package jianzhioffer;

import java.util.TreeSet;

/**
 * 扑克牌顺子
 * 大小王用0表示，可以代表任何数，判断抽出的5张牌能否组成顺子
 * 包含两张大王，两张小王
 */
public class Solution45扑克牌顺子 {
    public static boolean isContinuous(int[] numbers) {
        int num = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int number : numbers) {
            if (number == 0) {
                num++;
            } else {
                set.add(number);
            }
        }
        if ((num + set.size()) != 5) {
            return false;
        }
        return (set.last() - set.first()) < 5;
    }

    public static void main(String[] args) {
        int[] a = {3, 3, 0, 0, 0};
        System.out.println(isContinuous(a));
    }
}
