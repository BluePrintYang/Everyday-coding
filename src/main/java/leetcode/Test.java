package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        Solution225 s = new Solution225();
        s.push(2);
        int p = s.pop();
        int p2 = s.top();
        boolean t = s.empty();
        System.out.println(p);
    }
}
