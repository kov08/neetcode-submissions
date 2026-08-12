class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hMap = new HashMap<>();

        for(String str: strs){
            String key = getKey(str);
            hMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        List<List<String>> ans = new ArrayList<>(hMap.values());
        return ans;
    }

    private String getKey(String str){
        int[] kArr = new int[26];

        for(int i = 0 ; i < str.length(); i++){
            kArr[str.charAt(i) - 'a']++;
        }

        return Arrays.toString(kArr);
    }
}

// TC: O(n*m) n: length of strs and m: average length of str
// SC: O(n)
