class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,Character[]> mp = new HashMap<>();
        mp.put('2',new Character[]{'a','b','c'});
        mp.put('3',new Character[]{'d','e','f'});
        mp.put('4',new Character[]{'g','h','i'});
        mp.put('5',new Character[]{'j','k','l'});
        mp.put('6',new Character[]{'m','n','o'});
        mp.put('7',new Character[]{'p','q','r','s'});
        mp.put('8',new Character[]{'t','u','v'});
        mp.put('9',new Character[]{'w','x','y', 'z'});

        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(digits.length() != 0){
            rec(0, digits, mp, sb, ans);
        }
        return ans;
    }   

    private void rec(int ind, String digits, Map<Character,Character[]> mp,
     StringBuilder sb, List<String> ans){
        if(ind == digits.length()){
            ans.add(sb.toString());
            return;
        }

        for(Character ch: mp.get(digits.charAt(ind))){
            rec(ind+1, digits, mp, sb.append(ch), ans);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}

// TC O(N*4^n)
// SC O(N)
