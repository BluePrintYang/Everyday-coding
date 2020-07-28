package jianzhioffer;

import java.util.ArrayList;

/**
 * @Author: yangllong
 * @DATE: 2020/7/2 12:38
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 */
public class Solution64滑动窗口的最大值 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (size <= 0 || size > num.length) return ans;
        for (int i = 0; i <= num.length - size; i++) {
            int max = num[i];
            for (int j = i; j <= i + size - 1; j++) {
                if (num[j] > max) max = num[j];
            }
            ans.add(max);
        }
        return ans;
    }
}
