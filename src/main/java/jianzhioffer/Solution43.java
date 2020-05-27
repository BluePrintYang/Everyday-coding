package jianzhioffer;

import java.util.ArrayList;

/**
 * 和为S的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 小的先输出
 */
public class Solution43 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(array[i]);
                    list.add(array[j]);
                    lists.add(list);
                }
            }
        }
        if (lists.size()==0) return new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).get(0) * lists.get(i).get(1) < min) {
                min = lists.get(i).get(0) * lists.get(i).get(1);
                minIndex = i;
            }
        }
        return lists.get(minIndex);
    }
}
