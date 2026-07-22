import java.util.HashMap;

class Solution {
    public int[] findErrorNums(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int duplicate = 0;
        int missing = 0;

        // Find duplicate and missing
        for (int i = 1; i <= nums.length; i++) {

            if (!map.containsKey(i)) {
                missing = i;
            }

            if (map.getOrDefault(i, 0) == 2) {
                duplicate = i;
            }
        }

        return new int[]{duplicate, missing};
    }
}