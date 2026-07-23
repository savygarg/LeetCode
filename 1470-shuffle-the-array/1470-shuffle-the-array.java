class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int[] temp = new int[2 * n];
        int i = 0;
        int j = n;
        int k = 0;
        while(i < n){
            temp[k++] = nums[i++];
            temp[k++] = nums[j++];
        }
        return temp;
    }
}