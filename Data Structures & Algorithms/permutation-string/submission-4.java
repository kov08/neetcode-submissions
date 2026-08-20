class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if(l1 > l2) return false;

        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for(int i = 0; i < l1; i++){
            a1[s1.charAt(i) - 'a']++;
            a2[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < l2 - l1; i++){
            if(Arrays.equals(a1, a2)) return true;

            a2[s2.charAt(i) - 'a']--;
            a2[s2.charAt(i + l1) - 'a']++;
        }
        // Here, we were not able to check the last window because in the last a2 addition it will throw ArrayIndexOutOfBound exception 
        return Arrays.equals(a1, a2);
    }
}

// TC O(n) n = s2.length() 
// SC O(1)
