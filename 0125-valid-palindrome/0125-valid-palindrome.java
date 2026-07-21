class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        s = s.toLowerCase();
        String str = "";
        for(int i = 0; i < n ; i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                str += ch;
            }
        }
        int ne = str.length();
        for(int i = 0;i<ne/2;i++){
            if(str.charAt(i) != str.charAt(ne-i-1)){
                return false;
            }
        }
        return true;
    }
}