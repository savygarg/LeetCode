class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int k = 0;
        for(int i = 0; i <nums.length;i++){
           k ^= nums[i];
        }
        return k;
    }
}