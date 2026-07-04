class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int remove = val;
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != remove){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}