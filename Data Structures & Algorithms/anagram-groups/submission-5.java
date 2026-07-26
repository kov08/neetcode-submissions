class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        
        for(String str: strs){
            String key = generateKey(str);
            mp.computeIfAbsent(key, k->new ArrayList<>()).add(str);
        }

        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: mp.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }

    private String generateKey(String str){
        int[] key = new int[26];
        for(int i = 0; i < str.length(); i++){
            key[str.charAt(i) - 'a']++;
        }
        return Arrays.toString(key);
    }
}
