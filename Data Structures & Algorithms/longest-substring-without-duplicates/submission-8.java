class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s == null) return 0;
        int l = 0, maxLength = 1;
        Set<Character> set = new HashSet<>();
        for(int r = 0; r < s.length(); r++){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}

// TC: O(n)
// SC: O(n)
