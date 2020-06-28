package jianzhioffer;

/**
 * @Author yangllong
 * @Date 2020/5/28 22:19
 * 把字符串转换为整数
 * 要求不能使用字符串转换整数的库函数。数值为0或者字符串不是一个合法的数值则返回0
 * 示例输入
 * +2147483647
 * 1a33
 * 输出
 * 2147483647
 * 0
 */
public class Solution49字符串转换为整数 {
    public static int StrToInt(String str) {
        if (str.length() == 0 || str.trim().equals("")) return 0;
        int p = str.length() - 1;
        int ans = 0;
        int weight = 1;
        while (p >= 0) {
            if (str.charAt(p) == '+' && p == 0) return ans;
            if (str.charAt(p) == '-' && p == 0) return -ans;
            if (str.charAt(p) >= '0' && str.charAt(p) <= '9') ans = ans + weight * (str.charAt(p) - '0');
            else return 0;
            p--;
            weight *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "-2147483649";
//        System.out.println("-2147483649");
        System.out.println(StrToInt(s));
    }
}
