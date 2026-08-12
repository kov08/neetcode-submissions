class Solution {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if(sLen != tLen) return false;

        int[] freq = new int[26];

        for(int i = 0; i < sLen; i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for(int num : freq){
            if(num != 0) return false;
        }

        return true;
    }
}

// TC: O(n)
// SC: O(1)
