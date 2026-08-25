import java.util.*;

class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        // Max Heap
        left = new PriorityQueue<>(Collections.reverseOrder());

        // Min Heap
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {

        // Add to left first
        left.add(num);

        // Make sure every element in left <= every element in right
        if (!right.isEmpty() && left.peek() > right.peek()) {
            right.add(left.poll());
        }

        // Balance the sizes
        if (left.size() > right.size() + 1) {
            right.add(left.poll());
        }

        if (right.size() > left.size()) {
            left.add(right.poll());
        }
    }
    
    public double findMedian() {

        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }

        return left.peek();
    }
}