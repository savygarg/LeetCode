class Solution {
    public int compress(char[] chars) {
        int l = chars.length;
        int index = 0;
        int i = 0;
        
        while(i < l){
            char ch = chars[i];
            int count = 0;
            while(i < l && chars[i] == ch ){
                count++;
                i++;
            }
            chars[index++] = ch;
            if(count > 1){
                String str = String.valueOf(count);
                for(char c: str.toCharArray()){
                    chars[index++] = c;
                }
            }
        }
        return index;
    }
}