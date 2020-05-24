package jianzhioffer;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void mergeSortCore(int[] array, int low, int high) {
        if (low == high) return;
        int mid = ((high - low) >> 1) + low;
        mergeSortCore(array, low, mid);
        mergeSortCore(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    public static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = 0, p1 = low, p2 = mid + 1;
        while (p1 <= mid && p2 <= high) {
            temp[i++] = array[p1] <= array[p2] ? array[p1++] : array[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = array[p1++];
        }
        while (p2 <= high) {
            temp[i++] = array[p2++];
        }
        for (i = 0; i < temp.length; i++) {
            array[low + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 3, 56, 34, 24, 654, 7};
        System.out.println(Arrays.toString(arr));
        mergeSortCore(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
