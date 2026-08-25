class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Max Heap
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> {
                if (map.get(a).equals(map.get(b))) {
                    return Character.compare(a, b);
                }
                return map.get(b) - map.get(a);
            }
        );

        // Add all characters
        for (char ch : map.keySet()) {
            pq.add(ch);
        }

        StringBuilder ans = new StringBuilder();

        // Build answer
        while (!pq.isEmpty()) {
            char ch = pq.poll();

            for (int i = 0; i < map.get(ch); i++) {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}