package interview.daxi7_3;

import java.util.*;

/**
 * @Author: yangllong
 * @DATE: 2020/7/3 20:42
 */
public class Solution3 {

    int[] visit = new int[10000];

    int minPath(int n, int[][] edges, int start, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; i++) {
            visit[i] = 0;
        }
        dfs(edges, start, end, 0);
        return 0;
    }

    Map<Integer, Map<Integer, Integer>> getNext(int[][] edges, int start) {
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            if (edge[0] == start) {
                Map<Integer, Integer> nextNode = new HashMap<>();
                nextNode.put(edge[1], edge[2]);
                map.put(start, nextNode);
            }
        }
        return map;
    }

    private void dfs(int[][] edges, int start, int end, int index) {
        int min = Integer.MAX_VALUE;
        visit[index] = 1;
        if (start == end) return;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] != end && visit[i] == 0) {
                min = min | edges[i][2];
                dfs(edges, edges[i][1], end, i);
            }
        }
    }


    public static void main(String[] args) {
        int[][] a = new int[10][10];
        a[0][0] = 1;
        System.out.println(Arrays.deepToString(a));
    }
}
