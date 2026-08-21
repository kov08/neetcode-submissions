class Solution {
    public String minWindow(String s, String t) {
        int ls = s.length(), lt = t.length();
        
        if(s == null || t == null || ls < lt) return "";

        Map<Character, Integer> mp = new HashMap<>();
        for(char ch:  t.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
        }

        int count = 0, l = 0, startIdx = 0, minLen = Integer.MAX_VALUE;
        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);

            if(mp.containsKey(ch)){
                mp.put(ch, mp.get(ch) -1);
                if(mp.get(ch) >= 0){
                    count++;
                }
            }

            while(count == lt){
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    startIdx = l;
                }

                char cr = s.charAt(l);
                if(mp.containsKey(cr)){
                    mp.put(cr, mp.get(cr)+1);
                    if(mp.get(cr) > 0){
                        count--;
                    }
                }               
                l++;
            }
        }
    return minLen == Integer.MAX_VALUE ?  "" : s.substring(startIdx, startIdx+minLen);
    }
}


// TC O(m + n) || m: s.length() n: t.length()
// SC O(k) || k num of unique char in t