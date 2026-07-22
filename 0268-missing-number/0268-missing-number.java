class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int c  = n * (n+1)/2;
        int a = 0;
        for(int num : nums){
            a += num;
        }
        return c - a;
    }
}