package jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class Solution41 {
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : array) {
            if (map.containsKey(value)) map.put(value, 2);
            else map.put(value, 1);
        }
        int rep = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                num1[0] = array[i];
                rep = i;
                break;
            }
        }
        for (int i = rep + 1; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                num2[0] = array[i];
                break;
            }
        }

    }
}
