package datastructure.tiba;

import java.util.*;

/**
 * @Author: yangllong
 * @DATE: 2020/6/30 23:02
 */
public class _回路 {
    static List<Point> list = new ArrayList<>();
    static Map<Point, Integer> map = new HashMap<>();
    static boolean first = true;

    public static String solve(int[] param, Point[] edge) {
        // write code here
        int n = param[0];
        int m = param[1];
        for (Point point : edge) {
            list.add(point);
            map.put(point, 0);
        }
        return judge(1) ? "Yes" : "No";
    }

    public static boolean judge(int state) {
        if (state == 1 && !first) return true;
        first = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).x == state && map.get(list.get(i)) == 0) {
                map.put(list.get(i), 1);
                judge(list.get(i).y);
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] p = {4,4};
        Point[] po = {new Point(1,2),new Point(2,3),new Point(3,4),new Point(4,1)};
        _回路 ac = new _回路();
        System.out.println(ac.solve(p, po));
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    //并查集
    private int[] uninonFindSet;
    //连接1号节点的节点集
    private HashSet<Integer> nodeToOne;
    //连接1号节点的连通子图(用并查集中的头节点代表一个连通子图)
    private HashSet<Integer> linkToOne;

    public String solve1(int[] param, Point[] edge) {
        //排除特例
        if (param[1] == 0)
            return "NO";

        //构建并查集
        createUnionFindSet(param[0], edge);

        //判断1号节点是否存在回路，返回结果
        return isCircuit();
    }

    private String isCircuit() {
        //根据1号节点的连接点，将1号节点与连通子图关联起来
        for (Integer node : nodeToOne) {
            Integer head = findHead(node);
            //如果连通子图的头节点已经连接了1号节点，则存在回路；
            if (linkToOne.contains(head)) {
                return "Yes";
            } else {
                //否则，在集合中添加连通子图的头节点；
                linkToOne.add(head);
            }
        }
        return "No";
    }

    private void initialize(int n) {
        //数组初始化时，默认每个节点的boss为0
        uninonFindSet = new int[n + 5];
        //连接1的节点默认估计值为 128 个
        nodeToOne = new HashSet<Integer>(128);
        //连接1的boss节点默认估计值为 128 个
        linkToOne = new HashSet<Integer>(128);
    }

    private void createUnionFindSet(int n, Point[] edge) {
        initialize(n);
        for (Point p : edge) {
            //只记录1号节点的连接点，不参与构建并查集
            if (p.x == 1 || p.y == 1) {
                //注意：本程序没有考虑 (1,x),(x,1) 这种连接关系
                int node = p.x != 1 ? p.x : p.y;
                nodeToOne.add(node);
            } else if (!isSameHead(p.x, p.y)) {
                unionSet(p.x, p.y);
            }
        }
    }

    private boolean isSameHead(int x, int y) {
        return findHead(x) == findHead(y);
    }

    private void unionSet(int u, int v) {
        int uHead = findHead(u), vHead = findHead(v);
        uninonFindSet[uHead] = vHead;
    }

    //非递归版本：防止测试数据暴栈
    private int findHead(int node) {
        int head = node;
        while (uninonFindSet[head] != 0) {
            //真正的头节点 = 头节点的头节点
            head = uninonFindSet[head];
        }
        //并查集扁平化
        int curNode = node, nextNode = uninonFindSet[node];
        while (nextNode != 0) {
            uninonFindSet[curNode] = head;
            curNode = nextNode;
            nextNode = uninonFindSet[nextNode];
        }
        return head;
    }
}
