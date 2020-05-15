package interview;

import interview.thread.MyThread;

public class Base {
    public static void main(String[] args) {

        /*
         float s = 1.0是错误的，1.0为double类型
         */
        float s = 1.0f;
        /*
        |位运算符，二进制
         */
        System.out.println(3|9);

        MyThread myThread1 = new MyThread();
        myThread1.start();

    }
}
