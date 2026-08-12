class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < n;i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek() == ch){
                st.pop();
            }
            else {
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : st){
            sb.append(ch);
        }
        return sb.toString();
    }
}