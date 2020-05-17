package jianzhioffer;

/**
 * 不用加减乘除做加法
 * 两数与操作左移一位加两数异或
 */
public class SolutionAdd {
    public static int Add(int num1, int num2) {
        int and = num1 & num2;
        int xor = num1 ^ num2;
        //迭代
        while (and != 0) {
            int temp = and << 1;
            and = temp & xor;
            xor = temp ^ xor;
        }
        return xor;
        //递归
//        if (and == 0) return xor;
//        return Add(and << 1, xor);
    }

    public static void main(String[] args) {
        System.out.println(Add(100, 901));
    }
}
