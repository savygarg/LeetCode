class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int PrefixSum = 0;
        int count = 0;
        map.put(0,1);
        for(int num : nums){
            PrefixSum += num;
            if(map.containsKey(PrefixSum - k)){
                count += map.get(PrefixSum - k);}
                map.put(PrefixSum, map.getOrDefault(PrefixSum,0)+1);
            
           
        }
         return count;
    }
}