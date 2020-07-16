package interview.daxi7_3;

import java.util.Arrays;

/**
 * @Author: yangllong
 * @DATE: 2020/7/3 17:48
 * 杭州达西公司笔试题目1
 * 合并时间区间
 */
public class Solution1 {
    int[][] merge(int[][] intervals) {
        //数组为空直接返回
        if (intervals.length <= 1) return intervals;
        if (intervals[0].length == 0) return intervals;
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        //从第二个区间开始遍历
        for (int i = 1; i < intervals.length; i++) {
            //cur为当前区间
            int[] cur = intervals[i];
            //当前区间能与前一个区间合并
            if (cur[0] <= intervals[i - 1][1]) {
                //修改前一个区间
                intervals[i - 1][1] = Math.max(intervals[i - 1][1], cur[1]);
                //后面区间依次往前覆盖
                int temp = i;
                while ((temp + 1) < intervals.length) {
                    intervals[temp] = intervals[temp + 1];
                    temp++;
                }
                //修改原二维数组，即去掉最后一个区间
                intervals = Arrays.copyOfRange(intervals, 0, intervals.length - 1);
                //由于覆盖了区间，需要继续从当前位置区间进行比较
                i--;
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
//        int[][] a = {{1, 3}, {2, 6}, {5, 10}, {15, 18}};
        int[][] a = {{1,2}};
//        int[][] a = {{0,2},{1,4},{3,5}};
        System.out.println(Arrays.deepToString(a));
        int[][] merge = solution1.merge(a);
        System.out.println(Arrays.deepToString(merge));
    }
}
