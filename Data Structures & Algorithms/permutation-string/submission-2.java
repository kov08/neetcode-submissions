class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if(l1 > l2) return false;

        int[] a1 = new int[26];
        int[] a2 = new int[26];

        for(int i = 0; i < l2; i++){
            if(i < l1) a1[s1.charAt(i) - 'a']++;
            a2[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(a1[i] > a2[i]) return false;
        }

        int l = 0, r = l1-1;
        // generate a key for s1 and compare it with every substring of length of s1
        String k1 = genKey(s1, 0, l1-1);

        while(r < l2){
                if(a1[s2.charAt(l) - 'a'] != 0){
                    String k2 = genKey(s2, l, r);
                    if(check(k1, k2)) return true;
                }
                r++;
                l++;;
        }
        return false;
    }

    private boolean check(String k1, String k2){
        if(!k1.equals(k2)) return false;
        else return true;
    }

    private String genKey(String s, int l, int r){
        int[] arr = new int[26];
        for(int i = l; i <= r; i++){
            arr[s.charAt(i) - 'a']++;
        }
        return Arrays.toString(arr);
    }
}

