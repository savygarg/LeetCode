class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] visitedStep = new int[n];
        int ans = -1;
        int step = 1;

        for (int i = 0; i < n; i++) {
            if (visitedStep[i] != 0) {
                continue;
            }
            int startStep = step;
            int curr = i;

            while (curr != -1 && visitedStep[curr] == 0) {
                visitedStep[curr] = step++;
                curr = edges[curr];
            }

            if (curr != -1 && visitedStep[curr] >= startStep) {
                ans = Math.max(ans, step - visitedStep[curr]);
            }
        }

        return ans;
    }
}