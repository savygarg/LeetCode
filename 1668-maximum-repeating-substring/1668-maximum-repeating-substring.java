class Solution {
    public int maxRepeating(String sequence, String word) {

        String s = word + "$" + sequence;

        int n = s.length();
        int m = word.length();

        int[] z = new int[n];

        int left = 0;
        int right = 0;
        for (int i = 1; i < n; i++) {

            if (i <= right) {
                z[i] = Math.min(right - i + 1, z[i - left]);
            }

            while (i + z[i] < n &&
                   s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }
        }

        int answer = 0;
        for (int i = m + 1; i < n; i++) {

            if (z[i] >= m) {

                int count = 0;
                int j = i;
                while (j < n && z[j] >= m) {
                    count++;
                    j += m;
                }

                answer = Math.max(answer, count);
            }
        }

        return answer;
    }
}