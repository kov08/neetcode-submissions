class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();

        for(String st : strs){
            char[] k = new char[26];
            for(char ch : st.toCharArray()){
                k[ch - 'a'] += 1;
            }
            // for(int i = 0; i < st.length(); i++){
            //     k[st.charAt(i) - 'a'] += 1;
            // }
            // String key = Arrays.toString(k);
            String key = new String(k);
            mp.computeIfAbsent(key, str -> new ArrayList<String>()).add(st);
        }

        List<List<String>> ans = new ArrayList<>(mp.values());
        return ans;
    }
}

// TC O(N*M) Where N is the length of the strs arrray and M is maximum length of String 
// SC: O(N*M) where N is the length of the map and M is the average length of String 