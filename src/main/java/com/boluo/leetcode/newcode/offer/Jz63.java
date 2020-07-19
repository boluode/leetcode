package com.boluo.leetcode.newcode.offer;

import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后
 * 位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Jz63 {

    private PriorityQueue<Integer> min = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> max = new PriorityQueue<Integer>((o1, o2) -> o2.compareTo(o1));

    public static void main(String[] args) {

        Jz63 jz63 = new Jz63();
        for (int i = 1; i < 10; i++) {

            int random = new Random().nextInt(100);
            jz63.insert(random);
            System.out.println(jz63.getMedian());
        }
    }

    public void insert(Integer num) {

        max.offer(num);
        min.offer(max.poll());
        if(max.size() < min.size()) {
            max.offer(min.poll());
        }
    }

    public Double getMedian() {

        if(min.isEmpty() && max.isEmpty()) {
            return null;
        }
        if(min.size() != max.size()) {

            return Double.valueOf(max.peek());
        }
        return (min.peek() + max.peek()) / 2.0;
    }
}
