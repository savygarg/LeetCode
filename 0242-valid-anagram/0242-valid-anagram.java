class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int n1 = t.length();
        
        if(n != n1){
            return false;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1,arr2);
    }
}