package jianzhioffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组中重复的数字
 * 输出是第一个重复的数字
 */
public class SolutionRepeatNum {
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (length <= 0) {
            duplication[0] = -1;
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(numbers[i]);
            if (set.size() == i) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}
