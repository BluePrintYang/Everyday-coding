package others;

import java.util.LinkedList;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        System.out.println(16>>1);
        List<String> a = new LinkedList<>();
        a.add("ss");
        List<? extends Integer> b = new LinkedList<>();
        System.out.println(a.getClass()==b.getClass());

    }
}
