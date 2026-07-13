class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int index = 0;
        for(int i = 0; i < n;i++){
            if(nums[i] == 0){
                arr[index++] = 0;
            }
        }
        for(int i = 0; i < n;i++){
            if(nums[i] == 1){
                arr[index++] = 1;
            }
        }
        for(int i = 0; i < n;i++){
            if(nums[i] == 2){
                arr[index++] = 2;
            }
        }
        for(int i = 0;i<n;i++){
            nums[i] = arr[i];
        }
    }
}