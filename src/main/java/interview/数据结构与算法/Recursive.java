package interview.数据结构与算法;

public class Recursive {
    public static void main(String[] args) {
        System.out.println(hanoi(90));
    }

    public static int hanoi(int n) {
        return (1 << n )- 1;
    }
}
