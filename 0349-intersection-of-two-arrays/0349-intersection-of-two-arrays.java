class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       int n1 = nums1.length;
       int n2 = nums2.length;
       HashSet<Integer> set = new HashSet<>();
       for(int i = 0 ; i < n1; i++){
        set.add(nums1[i]);
       }
       HashSet<Integer> common = new HashSet<>();
       for(int i = 0; i < n2;i++){
            if(set.contains(nums2[i])){
                common.add(nums2[i]);
            }
       }
       int[] res = new int[common.size()];
       int i = 0;
       for(int x : common){
        res[i] += x;
        i++;
       }
       return res;
    }
}