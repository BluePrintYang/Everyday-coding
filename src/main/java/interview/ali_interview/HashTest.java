package interview.ali_interview;

public class HashTest {
    public static void main(String[] args) {
        String s = "123";
        int i = 123;
        System.out.println(s.hashCode());
        System.out.println(Integer.hashCode(i));
        System.out.println(-4 >>> 2);
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(4 >> 1));
        System.out.println(Integer.toBinaryString(4 << 3));
    }
}
