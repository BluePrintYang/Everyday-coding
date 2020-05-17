package datastructure;

import java.util.Arrays;

public class MySort {


    /**
     * 直接插入排序
     * 一个n-1次的for循环为需要插入的次数，一个while循环是将要插入的数与前面的数比大小
     *
     * @param a 待排序数组
     */
    private static void insertSort(int[] a) {
        if (a.length == 0) return;
        for (int i = 1; i < a.length; i++) {//要插入的次数为数组长度减一
            int insertNum = a[i];//要插入的数字
            int j = i;//已经排好序的元素个数
            while (j > 0 && a[j - 1] > insertNum) {//从后往前一个一个比较，把比insertNum大的往后移一位
                a[j] = a[j - 1];//比insertNum大的后移
                j--;//再和前面一个数比较大小,前面没有数了(此时j=0)就跳出while循环
            }
            a[j] = insertNum;//将要插入的数放在要插入的位置
        }
    }

    /**
     * 希尔排序
     *
     * @param a 待排序数组
     */
    private static void shellSort(int[] a) {
        if (a.length == 0) return;
        int len = a.length;
        while (len != 0) {
            len = len / 2;
            for (int g = 0; g < len; g++) {
                for (int i = g + len; i < a.length; i += len) {
                    int j = i - len;
                    int temp = a[i];
                    for (; j >= 0 && a[j] > temp; j -= len) {
                        a[j + len] = a[j];
                    }
                    a[j + len] = temp;
                }
            }
        }
    }


    /**
     * 快速排序
     *
     * @param a    待排序数组
     * @param firstIndex  数组最左边元素索引
     * @param lastIndex 数组最右边元素索引
     */
    public static void quickSort(int[] a, int firstIndex, int lastIndex) {
        int start = firstIndex;
        int end = lastIndex;
        int key = a[firstIndex];
        while (end > start) {//这里不要写成大于等于，否则会出现死循环
            //从后往前比较
            while (end > start && a[end] >= key) {//这里的大于和大于等于也不能加等号和删等号，否则会出现越界（前面加等号）和死循环（后面删等号），下面的while循环同理
                //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            }
            if (a[end] < key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while (end > start && a[start] <= key) {
                //如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            }
            if (a[start] > key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还是可能是不一样的，进行下面的递归调用
        }
        //递归
        if (start > firstIndex) quickSort(a, firstIndex, start - 1);
        if (end < lastIndex) quickSort(a, end + 1, lastIndex);
    }




    public static void main(String[] args) {
        int[] a = {6, 4, 8, 42, 56, 6, 7, 33, 55, 22, 'A', '#', '&', 31, 34, 32, 36, 75, 33, 22, 55, 77, 88, 44, 3, 74, 2,
                32, 56, 45, 63, 34, 67, 45, 34, 52, 63, 4, 47, 45};
        int[] b = a.clone();
        int[] c = a.clone();

        System.out.println("a数组排序前" + Arrays.toString(a));

        long startTime = System.currentTimeMillis();
        insertSort(a);
        long endTime = System.currentTimeMillis();
        System.out.println("插入排序time:" + (endTime - startTime) + "ns");
        System.out.println("插入排序后" + Arrays.toString(a));

        System.out.println("b数组排序前" + Arrays.toString(b));
        startTime = System.currentTimeMillis();
        shellSort(b);
        endTime = System.currentTimeMillis();
        System.out.println("希尔排序time:" + (endTime - startTime) + "ns");
        System.out.println("希尔排序后" + Arrays.toString(b));

        System.out.println("c数组排序前" + Arrays.toString(c));
        startTime = System.currentTimeMillis();
        quickSort(c, 0, c.length - 1);
        quickSort(c, 0, c.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("快速排序排序time:" + (endTime - startTime) + "ns");
        System.out.println("快速排序后" + Arrays.toString(b));
    }


}
