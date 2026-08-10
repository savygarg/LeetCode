
class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            String token = tokens[i];

            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {

                int b = st.pop();
                int a = st.pop();

                int result = 0;

                if (token.equals("+"))
                    result = a + b;

                else if (token.equals("-"))
                    result = a - b;

                else if (token.equals("*"))
                    result = a * b;

                else if (token.equals("/"))
                    result = a / b;

                st.push(result);
            }
            else {
                st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }
}