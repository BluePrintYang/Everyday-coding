package datastructure.tiba;


import java.util.HashMap;
import java.util.Map;

public class _牛妹的蛋糕 {
    public static int cakeNumber(int n) {
        // write code here
        int num = 1;
        while (--n != 0) {
            num = (int) ((num + 1) * 1.5);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(cakeNumber(3));
    }
}
