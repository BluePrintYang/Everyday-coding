package interview.huawei4_29;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 求城市1到N的最短路径，同时路费足够，无法到达返回-1
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();//硬币数
        int N = s.nextInt();//城市数
        int R = s.nextInt();//路数
        List<int[]> list = new ArrayList<>();
        while (R > 0) {
            int[] road = new int[4];
            road[0] = s.nextInt();//起始城市
            road[1] = s.nextInt();//目标城市
            road[2] = s.nextInt();//路长度
            road[3] = s.nextInt();//路费
            list.add(road);
            R--;
        }
    }
}
