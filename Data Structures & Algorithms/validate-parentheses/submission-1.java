class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if(len < 2) return false;

        Map<Character, Character> mp = new HashMap<>();
        mp.put(')', '(');
        mp.put('}', '{');
        mp.put(']', '[');
        
        Deque<Character> st = new ArrayDeque<>();

        for(int i = 0; i < len; i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            } else if (st.isEmpty() || mp.get(ch) != st.pop()){
                return false;
            }
        }

        return st.isEmpty();
    }
}

// TC: O(N) N: length of the string
// SC: O(N) N: length of the stack
