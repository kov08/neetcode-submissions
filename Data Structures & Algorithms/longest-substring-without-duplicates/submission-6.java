class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()  <= 1) return s.length();
        int len = s.length();

        int ls = 0;
        Set<Character> hs = new HashSet<>();

        for(int r = 0, l = 0; r < len; r++){
            char ch = s.charAt(r);
            while(hs.contains(ch)){
                hs.remove(s.charAt(l));
                l++;
            }

            hs.add(ch);
            ls = Math.max(ls, r - l + 1);
        }

        return ls;
    }
}

// TC O(N) N: length of string
// SC O(LS) 
