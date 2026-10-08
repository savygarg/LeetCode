class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;

        Arrays.sort(costs, (a, b) ->
            Integer.compare(a[0] - a[1], b[0] - b[1])
        );

        int ans = 0;

        for (int i = 0; i < costs.length; i++) {

            if (i < n) {
                ans += costs[i][0];
            } 
            else {
                ans += costs[i][1];
            }
        }

        return ans;
    }
}