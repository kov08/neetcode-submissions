class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if(l1 > l2) return false;
    
        // create an array to cal freq of s1 and cal len
        int[] freq = new int[26];
    
        for(int i = 0; i < l1; i++){
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        if(allZero(freq)) return true;

        for(int j = l1; j < l2; j++){
            freq[s2.charAt(j) - 'a']--;
            freq[s2.charAt(j - l1) - 'a']++;
            if(allZero(freq)) return true;
        }

        return false;
    }

    private boolean allZero(int[] freq){
        for(int i: freq){
            if(i != 0) return false;
        }
        return true;
    }
}

// TC: O(s2.length());
// SC: O(1) for 26 size array
