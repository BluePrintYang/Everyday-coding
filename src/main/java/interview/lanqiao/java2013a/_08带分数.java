package interview.lanqiao.java2013a;

import java.util.Scanner;

/**
 * 给定整数N<1000*1000   使其能用1到9的排列，只添加一个加号和除号表示
 * 例如  100  =  82 + 3546 / 197
 * 只要求计算有多少种表示方法
 *
 * 测试用例
 * 输入：
 * 100
 * 输出11
 *
 * 输入105
 * 输出6
 *
 */
public class _08带分数 {
    static int ans;
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] arr = {1, 2, 3};
        f(arr, 0);
        System.out.println(ans);
    }

    //确认某一个全排列的第k位
    private static void f(int[] arr, int k) {
        if (k == 9) {//全部确认
            check(arr);
            return;
//            System.out.println(Arrays.toString(arr));
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

    private static void check(int[] arr) {

        //加号前面的字符最多是7
        for (int i = 1; i <= 7; i++) {
            int num1 = toInt(arr, 0, i);//加号前面的一段整数
            if (num1 >= N)continue;//如果此时加号的数额已经超过了N，没必要验算了
                //  除号前面的字符数
                for (int j = 1; j <= 8 - i; j++) {
                    int num2 = toInt(arr,i,j);
                    int num3 = toInt(arr,i+j,9-i-j);
                    if (num2%num3==0&&num1+num2/num3==N){
                        ans++;
                    }
                }
        }
    }

    private static int toInt(int[] arr, int pos, int len) {
        int t = 1;
        int ans = 0;
        for (int i = pos + len-1; i >= pos; i--) {
            ans += arr[i] * t;
            t *= 10;
        }
        return ans;
    }

}
