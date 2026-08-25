import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();

        // Count frequencies
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Max Heap
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> {
                if (!map.get(a).equals(map.get(b))) {
                    return map.get(b) - map.get(a);
                }

                return a.compareTo(b);
            }
        );

        // Add all words
        for (String word : map.keySet()) {
            pq.add(word);
        }

        // Get top k
        List<String> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }

        return result;
    }
}