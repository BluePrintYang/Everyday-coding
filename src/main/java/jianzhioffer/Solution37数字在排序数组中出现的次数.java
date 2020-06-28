package jianzhioffer;

/**
 * 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数
 * 二分搜索
 */
public class Solution37数字在排序数组中出现的次数 {
    public int GetNumberOfK(int[] array, int k) {
        int index = bisection(array, 0, array.length - 1, k);
        int count = 0;
        if (index != -1) {
            int aft = index;
            while (aft < array.length && array[aft] == k) {
                count++;
                aft++;
            }
            index--;
            while (index >= 0 && array[index] == k) {
                count++;
                index--;
            }
            return count;
        }
        return 0;
    }

    public int bisection(int[] array, int first, int last, int k) {
        if (first > last) return -1;
        int mid = (first + last) / 2;
        if (array[mid] == k) return mid;
        if (array[mid] < k) return bisection(array, mid + 1, last, k);
        if (array[mid] > k) return bisection(array, first, mid - 1, k);
        return mid;
    }
}
