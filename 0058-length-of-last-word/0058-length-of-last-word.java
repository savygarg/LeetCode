class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int len = 0;
        for(int i = n - 1; i >= 0 ; i --){
            char ch = s.charAt(i);
            if(ch == ' ' && len == 0){
                continue;
            }
            if(ch == ' '){
                break;
            }
            len++;
        }
        return len;
    }
}