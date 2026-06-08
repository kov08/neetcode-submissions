class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] dp  = new Boolean[s.length()+1];
        return rec(s, 0, set, dp);
    }

    private boolean rec(String s, int i, Set<String> set, Boolean[] dp){
        if(i == s.length()) return true;

        if(dp[i] != null) return dp[i];

        for(int j = i+1; j <= s.length(); j++){
            String pre = s.substring(i,j);
            if(set.contains(pre)){
                if(rec(s, j, set, dp)){
                    dp[j] = true;
                    return dp[j];
                }
            }  
        }
        dp[i] = false; 
        return dp[i];
    }
}
