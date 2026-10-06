class Solution {
    public int repeatedStringMatch(String a, String b) {

        int n = a.length();
        int m = b.length();

        int count = (m + n - 1) / n;

        StringBuilder repeated = new StringBuilder();

        for (int i = 0; i < count; i++) {
            repeated.append(a);
        }
        if (rabinKarp(repeated.toString(), b)) {
            return count;
        }
        repeated.append(a);

        if (rabinKarp(repeated.toString(), b)) {
            return count + 1;
        }

        return -1;
    }

    private boolean rabinKarp(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        if (m > n) {
            return false;
        }

        long base = 31;
        long mod = 1_000_000_007;

        long patternHash = 0;
        long windowHash = 0;
        long power = 1;
        for (int i = 0; i < m; i++) {
            patternHash =
                (patternHash * base + pattern.charAt(i)) % mod;

            windowHash =
                (windowHash * base + text.charAt(i)) % mod;

            if (i < m - 1) {
                power = (power * base) % mod;
            }
        }
        if (patternHash == windowHash &&
            text.substring(0, m).equals(pattern)) {
            return true;
        }
        for (int i = m; i < n; i++) {
            windowHash =
                (windowHash - text.charAt(i - m) * power % mod + mod) % mod;

            windowHash =
                (windowHash * base + text.charAt(i)) % mod;

            int start = i - m + 1;

            if (windowHash == patternHash &&
                text.substring(start, start + m).equals(pattern)) {
                return true;
            }
        }

        return false;
    }
}