package lanqiao.java2013a;


import java.util.ArrayList;

/**
 * 颠倒的价格
 * 4位数 包含数字1，2，5，6，8，9，0  一个数颠倒之后比原数小200多，一个比原数大800多，两者差值相加为558，求比颠倒后更大的那个数
 */
public class _04颠倒的价牌 {
    public static void main(String[] args) {
        ArrayList<Price> a1 = new ArrayList<>();
        ArrayList<Price> a2 = new ArrayList<>();
        //遍历四位数
        for (int i = 1000; i < 10000; i++) {
            String s = "" + i;
            if (s.contains("3")||s.contains("7")||s.contains("4"))continue;
            //颠倒，保存原值和差值
            int i1 = Integer.parseInt(reverse(s));
            int plus = i1 - i;
            if (plus > -300 && plus < -200) a1.add(new Price(i, plus));
            if (plus > 800 && plus < 900) a2.add(new Price(i, plus));
        }
        //找出差值和为558的
        for (Price p1 : a1) {
            for (Price p2 : a2) {
                if (p1.plus + p2.plus == 558) System.out.println(p1.p+" "+p1.plus+" "+p2.p+" "+p2.plus);
            }
        }
    }

    private static String reverse(String s) {
        char[] ans = new char[s.length()];
        for (int i = s.length()-1, j = 0; i >= 0; i--, j++) {
            char c = s.charAt(i);
            if (c == '9') ans[j] = '6';
            else if (c == '6') ans[j] = '9';
            else ans[j] = c;
        }
        return new String(ans);
    }

    private static class Price {
        private int p;
        private int plus;

        public Price(int p, int plus) {
            this.p = p;
            this.plus = plus;
        }
    }
}
