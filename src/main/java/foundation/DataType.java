package foundation;



/**
 * @Author yangllong
 * @Date 2020/6/1 17:03
 */
public class DataType {
    static class Test{
     static int a;
    }
    public static void main(String[] args) {
        int i = 3;
        byte by = 3;
        short s = 3;
        long l = 3;
        boolean bool = true;
        char c = '3' - '0';
        float f1 = 3, f2 = 3.25f, f3 = 3.1f;
//        float f4 = 3.0;//编译报错，3.0为double类型
        double d1 = 3, d2 = 3.1;
        System.out.println("i==by:" + (i == by));
        System.out.println(i == s);
        System.out.println(i == l);
        System.out.println(i == c);
        System.out.println(i == f1);
        System.out.println(f1 == d1);
        System.out.println(f2 == 3);//以上全为true
        System.out.println(f2 == 3.25);//true 二进制可以精确表示3.25(11.01)
        System.out.println(f1 == 3.1);//false 二进制无法精确表示1/10,就像十进制无法精确表示1/3
        System.out.println(f3 == d2);//false
        System.out.println(d2 == 3.1);//true


    }
}
