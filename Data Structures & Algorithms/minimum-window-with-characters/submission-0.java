class Solution {
    public String minWindow(String s, String t) {
        // if t is larger than s return empty String
        if (t.length() > s.length())
            return "";

        // Introduce two hashmaps to track string and window 
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // add elements in countT
        for (char ch : t.toCharArray()) {
            countT.put(ch, countT.getOrDefault(ch, 0) + 1);
        }

        // create two var to ensure that all the char in t is covered in the window
        int need = countT.size(), have = 0;
        int l = 0;

        int[] ind = { -1, -1 };
        int minLen = Integer.MAX_VALUE;

        // interating string s
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (countT.containsKey(ch) && window.get(ch).equals(countT.get(ch))) {
                have++;
            }

            while (need == have) {
                if(r - l + 1 < minLen){
                    ind[0] = l;
                    ind[1] = r;
                    minLen = r - l + 1;
                }
                // window contraction
                char lCh = s.charAt(l);
                window.put(lCh, window.get(lCh) - 1);
                if (countT.containsKey(lCh) && window.get(lCh) < countT.get(lCh) ) {
                    have--;
                }
                l++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(ind[0], ind[1] + 1);

    }
}

// TC: O(N + N) where N = s.length() and M: t.length()
// SC: )(P) P: total numbe rof unique characters in string s abd t
