package jianzhioffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: yangllong
 * @DATE: 2020/7/25 17:56
 * 我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Solution63数据流中的中位数 {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    int count = 0;

    public void Insert(Integer num) {
        if (count % 2 == 0){
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        }else {
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
    }

    public Double GetMedian() {
        if (count%2==0){
            return new Double(minHeap.peek()+ maxHeap.peek())/2;
        }else {
            return new Double(minHeap.peek());
        }
    }


}
