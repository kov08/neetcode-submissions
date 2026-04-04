class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for(String word : strs){
            String key = generateKey(word);
            mp.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        List<List<String>> res = new ArrayList<>();
        for(String key: mp.keySet()){
            res.add(mp.get(key));
        }

        return res;
    }

    private String generateKey(String word){
        char[] keyArr = new char[26];
        for(char ch: word.toCharArray()){
            keyArr[(int)ch-97]++;
        }
        return new String(keyArr);
    }
}

// TC: O(N * K);
// SC: O(N * K);
