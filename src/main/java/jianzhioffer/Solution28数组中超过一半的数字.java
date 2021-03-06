package jianzhioffer;

import java.util.HashMap;

/**
 * 数组中出现超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution28数组中超过一半的数字 {
    public static int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = array.length;
        int i = 0;
        while (i < len) {
            if (map.containsKey(array[i])) map.put(array[i], map.get(array[i]) + 1);
            else map.put(array[i], 1);
            if (map.get(array[i]) > (len / 2)) return array[i];
            i++;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,2,2,2,5,4,2};
        int i = MoreThanHalfNum_Solution(a);
        System.out.println(i);
    }
}
