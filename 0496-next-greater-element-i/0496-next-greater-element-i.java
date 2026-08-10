class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int n1 = nums2.length;
        
        Stack <Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = n1 - 1; i >= 0 ; i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
                if(stack.isEmpty()){
                    map.put(nums2[i], -1);
                }
                else {
                    map.put(nums2[i],stack.peek());
                }
                stack.push(nums2[i]);
            }
            int[] res = new int[n];
            for(int i = 0 ; i < n ; i++){
              res[i] = map.get(nums1[i]);
            }
            return res;
        
        
    }
}