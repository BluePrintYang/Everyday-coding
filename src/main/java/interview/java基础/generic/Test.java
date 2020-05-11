package interview.java基础.generic;


import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0, 1);
        list.add(0, 2);
        list.add(0, 3);
        System.out.println(list.indexOf(null));
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }


}
