class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > end) {
                end = piles[i];
            }
        }

        int answer = end;

        while (start <= end) {

            int k = start + (end - start) / 2;

            long hours = 0;

            for (int i = 0; i < piles.length; i++) {
                hours += (piles[i] + k - 1) / k;
            }

            if (hours <= h) {
                answer = k;
                end = k - 1;
            } else {
                start = k + 1;
            }
        }

        return answer;
    }
}