package jianzhioffer;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class Solution13数组奇数位于偶数前面 {
    public void reOrderArray(int [] array) {
        //开辟两个数组分别存奇数和偶数，再合并
        if (array.length==0)return;
        int[] odd = new int[array.length];
        int[] even = new int[array.length];
        int evenCount=0;
        int oddCount=0;
        for (int value : array) {
            if (value % 2 == 0) even[evenCount++] = value;
            else odd[oddCount++] = value;
        }
        for (int i = 0; i < array.length; i++) {
            if (i<oddCount)array[i]=odd[i];
            else array[i]=even[i-oddCount];
        }
    }
}
