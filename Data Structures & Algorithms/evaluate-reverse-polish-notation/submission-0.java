class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < tokens.length; i++){
            String s = tokens[i];
            if(s.equals("+")){
                st.push(st.pop() + st.pop());
            } else if(s.equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(b-a);
            } else if(s.equals("*")){
                st.push(st.pop() * st.pop());
            } else if(s.equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.push(b/a);
            } else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}
