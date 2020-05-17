package jianzhioffer;

import java.util.ArrayList;

/**
 * 把数组排成最小的数
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution32 {
    static ArrayList<String> list = new ArrayList<>();

    public static String PrintMinNumber(int[] numbers) {
        f(0, numbers);
        list.sort(String::compareTo);
        return String.valueOf(list.get(0));
    }


    private static void f(int i, int[] numbers) {
        if (i == numbers.length) {
            StringBuilder str = new StringBuilder();
            for (int number : numbers) {
                str.append(number);
            }
            list.add(String.valueOf(str));
        }

        for (int j = i; j < numbers.length; j++) {
            int temp = numbers[j];
            numbers[j] = numbers[i];
            numbers[i] = temp;
            f(i + 1, numbers);
            temp = numbers[j];
            numbers[j] = numbers[i];
            numbers[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 32, 321};
        String ans = PrintMinNumber(a);
        System.out.println(ans);
    }


    public String PrintMinNumber2(int [] numbers) {
        if(numbers == null || numbers.length == 0)return "";
        for(int i=0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                int sum1 = Integer.parseInt(numbers[i]+""+numbers[j]);
                int sum2 = Integer.parseInt(numbers[j]+""+numbers[i]);
                if(sum1 > sum2){
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        StringBuilder str = new StringBuilder(new String(""));
        for (int number : numbers) str.append(number);
        return str.toString();

    }
}
