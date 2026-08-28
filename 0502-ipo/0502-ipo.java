import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;

        // Min-heap: stores [capital required, profit]
        PriorityQueue<int[]> minCapitalHeap =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Max-heap: stores profits
        PriorityQueue<Integer> maxProfitHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        // Add all projects to min-heap
        for (int i = 0; i < n; i++) {
            minCapitalHeap.offer(new int[]{capital[i], profits[i]});
        }

        // Perform at most k projects
        for (int i = 0; i < k; i++) {

            // Move all affordable projects to max-heap
            while (!minCapitalHeap.isEmpty()
                    && minCapitalHeap.peek()[0] <= w) {

                maxProfitHeap.offer(minCapitalHeap.poll()[1]);
            }

            // No affordable project available
            if (maxProfitHeap.isEmpty()) {
                break;
            }

            // Choose the project with maximum profit
            w += maxProfitHeap.poll();
        }

        return w;
    }
}