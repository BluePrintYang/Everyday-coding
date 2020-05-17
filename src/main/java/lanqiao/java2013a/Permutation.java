package lanqiao.java2013a;


import java.util.Scanner;

public class Permutation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        f(arr, 0);
    }

    //确认某一个全排列的第k位
    private static void f(int[] arr, int k) {
        if (k == arr.length) {//全部确认
            print(arr);
        }

        //选定第k位，
        for (int i = k; i < arr.length; i++) {
            //将第i位与第k位交换
            int t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;

            // 移交下一层去确认k+1位
            f(arr, k + 1);

            //回溯（换回来）
            t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;
        }
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i!=arr.length-1)System.out.print(arr[i]+" ");
            else System.out.println(arr[i]);
        }
    }


}
