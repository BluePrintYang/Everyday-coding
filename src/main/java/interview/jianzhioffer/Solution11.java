package interview.jianzhioffer;

/**
 * 二进制中1的个数
 */
public class Solution11 {
    public int NumberOf1(int n) {

        //解法一：直接转二进制数1
        String s = Integer.toBinaryString(n);
        String[] split=s.split("");
        int a=0;
        for (String value : split) {
            if (value.equals("1")) {
                a++;
            }
        }
        return a;

//        解法二：每减1后与原数做&运算会减少一个1
       /* int count=0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;*/
    }
}
