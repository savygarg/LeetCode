import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        // {value, listIndex, elementIndex}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        
        int currentMax = Integer.MIN_VALUE;
        
        // Add first element from every list
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i).isEmpty()) {
                return new int[0];
            }
            
            int value = nums.get(i).get(0);
            minHeap.offer(new int[]{value, i, 0});
            currentMax = Math.max(currentMax, value);
        }
        
        int start = 0;
        int end = Integer.MAX_VALUE;
        
        while (minHeap.size() == nums.size()) {
            
            int[] current = minHeap.poll();
            
            int currentMin = current[0];
            int listIndex = current[1];
            int elementIndex = current[2];
            
            // Update answer
            if (currentMax - currentMin < end - start ||
               (currentMax - currentMin == end - start && currentMin < start)) {
                
                start = currentMin;
                end = currentMax;
            }
            
            // Move to next element in the same list
            if (elementIndex + 1 < nums.get(listIndex).size()) {
                
                int nextValue = nums.get(listIndex).get(elementIndex + 1);
                
                minHeap.offer(
                    new int[]{nextValue, listIndex, elementIndex + 1}
                );
                
                currentMax = Math.max(currentMax, nextValue);
                
            } else {
                break;
            }
        }
        
        return new int[]{start, end};
    }
}