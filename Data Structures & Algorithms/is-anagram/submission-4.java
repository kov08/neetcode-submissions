class Solution {
    public boolean isAnagram(String s, String t) {
        // return false if the size of the given strings are different
        if(s.length() != t.length()){
            return false;
        }

        // Declare an array of ch 26 for all 26 char
        int[] arr = new int[26];

        // run a loop to iterate string char
        for(int i = 0; i < s.length(); i++){
            arr[(int)(s.charAt(i)-97)] += 1;
            arr[(int)(t.charAt(i)-97)] -= 1;
        }

        for(int i: arr){
            if(i != 0){
                return false;
            }
        }

        return true;
    }
}

// TC: O(N) N: length of the String
// SC: O(1) constant space 26 char