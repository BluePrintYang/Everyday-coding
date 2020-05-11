package interview.jianzhioffer;

/**
 * 求double类型变量base的exponent（int类型）次方
 */
public class Solution12 {
    public static double Power(double base, int n) {
        //方法一：直接Math
//        return Math.pow(base,exponent);

//        方法二：
        double res = 1,curr = base;
        int exponent;
        if(n>0){
            exponent = n;
        }else if(n<0){
            if(base==0)
                throw new RuntimeException("分母不能为0");
            exponent = -n;
        }else{// n==0
            return 1;// 0的0次方
        }
        while(exponent!=0){
            if((exponent&1)==1)
                res*=curr;
            curr*=curr;// 翻倍
            exponent>>=1;// 右移一位
        }
        return n>=0?res:(1/res);
    }
}
