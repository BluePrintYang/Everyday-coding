package datastructure;


import java.util.ArrayList;

/**
 * @Author: yangllong
 * @DATE: 2020/6/30 23:32
 * 全排列
 */
public class Permutation {
    ArrayList<Integer> res = new ArrayList<>();

    void dfs(int[] p) {

        if (res.size() == p.length) {
            System.out.println(res.toString());
            return;
        }

        for (int i = 0; i < p.length; i++) {
            int c = p[i];
            if (c != -1) {
                res.add(c);
                p[i] = -1;
                dfs(p);
                res.remove(res.size() - 1);
                p[i] = c;
            }
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        int[] p = {1, 2, 3};
        permutation.dfs(p);
    }
}
