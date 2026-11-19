class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pair: richer){
            int rich = pair[0];
            int poor = pair[1];
            adj.get(poor).add(rich);
        }
        int[] answer = new int[n];
        Arrays.fill(answer,-1);
        for (int i = 0; i < n; i++) {
            dfs(i, adj, quiet, answer);
        }
        return answer;
    }
    private int dfs(int person, List<List<Integer>> adj, int[] quiet, int[] answer) {
        if (answer[person] != -1) {
            return answer[person];
        }
        int quietestPerson = person;

        for (int richerPerson : adj.get(person)) {
            int candidate = dfs(richerPerson, adj, quiet, answer);
            if (quiet[candidate] < quiet[quietestPerson]) {
                quietestPerson = candidate;
            }
        }

        answer[person] = quietestPerson;
        return quietestPerson;
    }
}