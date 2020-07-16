package interview.daxi7_3;

import java.util.*;

/**
 * @Author: yangllong
 * @DATE: 2020/7/3 20:42
 */
public class Solution3_1 {

    int[] visit = new int[10000];

    int minPath(int n, int[][] edges, int start, int end) {
        Map<Integer, Map<Integer, Integer>> edgesMap = getEdgesMap(n, edges);
        int result = dfs(edgesMap, start, end);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    //获得点到其它的距离集合
    private static Map<Integer, Map<Integer, Integer>> getEdgesMap(int n, int[][] edges) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
//        for (int[] edge : edges) {
//            if (map.containsKey(edge[0])) {
//                Map<Integer, Integer> keyMap = map.get(edge[0]);
//                keyMap.put(edge[1], edge[2]);
//            } else {
//                Map<Integer, Integer> next = new HashMap<>();
//                next.put(edge[1], edge[2]);
//                map.put(edge[0], next);
//            }
//        }
        List<int[]> list = new ArrayList<>(n);
        Collections.addAll(list, edges);
        list.forEach(e -> {
            int start = e[0];
            int end = e[1];
            int distance = e[2];
            map.computeIfAbsent(start, k -> new HashMap<Integer, Integer>(n));
            map.get(start).merge(end, distance, (a, b) -> b < a ? b : a);
        });
        return map;
    }


    //深度优先，获取所有可能的路径及惩罚
    private static int dfs(Map<Integer, Map<Integer, Integer>> edgesMap, int start, int end) {
        Map<Integer, Integer> startMap = edgesMap.get(start);
        int result = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> e : startMap.entrySet()) {
            int next = e.getKey();
            int path = e.getValue();
            if (next != end) {
                edgesMap.remove(start);
                path = path | dfs(edgesMap, next, end);
                edgesMap.put(start, startMap);
            }
            if (path < result) {
                result = path;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int[][] edges = {{1, 2, 1}, {2, 3, 3}, {1, 3, 100}};
        int[][] edges1 = {{1, 2, 1}, {2, 3, 2}, {1, 4, 3},{4,3,4}};
        Solution3_1 test = new Solution3_1();
        System.out.println(test.minPath(4, edges1, 1, 3));
    }
}
