class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
         }
          int limit = nums.length/3;
          for(int key : map.keySet()){
            if(map.get(key)> limit){
                arr.add(key);
            }
          }
        return arr;
    }
}