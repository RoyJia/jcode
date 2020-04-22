package common_check;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumWaitingTime {

    public static void main(String[] args) {
        int[] cars = {2, 8, 4, 3, 2};

        System.out.println(getMaximumWaitingTime(cars, 7, 11, 3));

    }

    static int getMaximumWaitingTime(int[] cars, int X, int Y, int Z) {
        /**
         * 我需要一种数据结构表示 (X, X 的容量, 消耗的量)
         * 这个问题的结果是 经过加油只有，被占用最长时间的桩子的时间
         */
        Map<Character, int[]> map = new HashMap<>();
        map.put('X', new int[] {X, 0});
        map.put('Y', new int[] {Y, 0});
        map.put('Z', new int[] {Z, 0});

        Queue<Map.Entry<Character, int[]>> minQueue = new PriorityQueue<>(
            (a, b) -> a.getValue()[0] == b.getValue()[0] ? a.getValue()[1] - b.getValue()[1] : a.getKey() - b.getKey()
        );
        minQueue.addAll(map.entrySet());

        int[] res = new int[3];
        List<Map.Entry<Character, int[]>> list = new ArrayList<>();

        for (int i=0; i<cars.length; i++) {
            int car = cars[i];

            while(!minQueue.isEmpty()) {
                if (!minQueue.isEmpty() && minQueue.peek().getValue()[0] < car) {
                    list.add(minQueue.poll());
                    if (minQueue.isEmpty()) return -1;
                } else {
                    Map.Entry<Character, int[]> e = minQueue.poll();
                    e.getValue()[0] -= car;
                    e.getValue()[1] += car;
                    list.add(e);

                    if (i == cars.length - 1) break;

                    res[e.getKey() - 'X'] += car;
                    minQueue.addAll(list);
                    list.clear();
                    break;
                }
            }
        }

        return Math.max(res[0], Math.max(res[1], res[2]));
    }
}