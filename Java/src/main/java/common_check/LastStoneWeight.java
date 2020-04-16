package common_check;

import java.util.Comparator;
import java.util.PriorityQueue;
public class LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeightWithPriorityQueue(stones));
    }

    static int lastStoneWeightWithPriorityQueue(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for (int s : stones) queue.offer(s);

        while (queue.size() > 1) {
            queue.offer(queue.poll() - queue.poll());
        }

        return queue.peek();
    }

    static int lastStoneWeight(int[] stones) {
        if (stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];
        for (int i=0; i<stones.length; i++) {
            int heaviestIndex = 0;
            int secondHeaviestIndex = 0;
            for (int j=0; j<stones.length; j++) {
                if (stones[j] > stones[heaviestIndex]) {
                    secondHeaviestIndex = heaviestIndex;
                    heaviestIndex = j;
                } else if (stones[j] > stones[secondHeaviestIndex] || heaviestIndex == secondHeaviestIndex) {
                    secondHeaviestIndex = j;
                }
            }
            if (stones[secondHeaviestIndex] == 0 || stones[heaviestIndex] == 0) break;

            if (stones[secondHeaviestIndex] == stones[heaviestIndex]) {
                stones[secondHeaviestIndex] = 0;
                stones[heaviestIndex] = 0;
            }

            if (stones[secondHeaviestIndex] < stones[heaviestIndex]) {
                stones[heaviestIndex] = stones[heaviestIndex] - stones[secondHeaviestIndex];
                stones[secondHeaviestIndex] = 0;
            }

        }

        System.out.println("--------------------------------");
        for (int i : stones) {
            System.out.println(i);
            if (i != 0) {
                System.out.println("+++++++++++++++++++++++++++");
                return i;
            }
        }
        return 0;
    }

}