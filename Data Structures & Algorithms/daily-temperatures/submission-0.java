class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        // iterate all temps
        for(int i = 0; i < temperatures.length; i++){
        // check each element and stack top if it is more than top change result array and pop the element 
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
            int prevTemp = st.peek();
                result[prevTemp] = i - prevTemp;
                st.pop(); 
            }
        // add index in the stack to change the result array
            st.push(i);
        }
        return result;
    }
}

// TC: O(n)
// SC: O(n)
