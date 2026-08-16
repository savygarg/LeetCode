import java.util.HashSet;
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);
        }
        int longest = 0;
        for(int x : set){
            if(!set.contains(x-1)){
                int curr = x;
                int count = 1;
                while(set.contains(curr+1)){
                    curr++;
                    count++;
                }
                longest = Math.max(longest,count);
            }
        }
        return longest;
    }
}