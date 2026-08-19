class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, mf = 0, ml = 0;
        int[] mfa = new int[26];

        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            mfa[ch- 'A']++;
            mf = Math.max(mf, mfa[ch - 'A']);

            while((r - l + 1) - mf > k){
                mfa[s.charAt(l) - 'A']--;
                l++;
                for(int i = 0; i < 26; i++){
                    mf = Math.max(mf, mfa[i]);
                }
            }   

            ml = Math.max(ml, (r-l+1));
        }
        return ml;
    }
}

// TC O(n + n) * 26 -> O(n^2)
// SC O(26) -> constant space
