package jianzhioffer;


/**
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class Solution36 {
    public static int count = 0;

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
            if (array[p1] > array[p2]) {
                count = (count + (mid - p1 + 1)) % 1000000007;
                temp[i++] = array[p2++];
            } else {
                temp[i++] = array[p1++];
            }
        }
        while (p1 <= mid) temp[i++] = array[p1++];
        while (p2 <= high) temp[i++] = array[p2++];
        for (i = 0; i < temp.length; i++) array[i + low] = temp[i];
    }

    public static int InversePairs(int[] array) {
        mergeSortCore(array, 0, array.length - 1);
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(InversePairs(a));
    }
}
