class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();

        for(String word: strs){
            String key = gen(word);
            mp.computeIfAbsent(key, v->new ArrayList<>()).add(word);
        }

        return new ArrayList<>(mp.values());
    }

    private String gen(String word){
        int[] k =  new int[26];
        for(int i = 0; i < word.length(); i++){
            k[word.charAt(i) - 'a']++;
        }
        return Arrays.toString(k);
    }
}

// TC: O(N * K) where N: for loop of N words in strs array and 
// K is the average length of words in strs

// SC: O(N * K): map of strs with average K length