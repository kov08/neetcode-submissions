class Solution {
    public int climbStairs(int n) {
        if( n <= 2) return n;
        // divide problem into number of smaller problem that either take 1 or 2 steps 
        // repeatatively perform this step until reached the given number
        // this leads to recurssion

        // Introduce dp[] to avoid repeated calculation
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        return rec(n ,dp);

    }

    private int rec(int n, int[] dp){
        // As the number is given I would start from that number till I reached at 0 
        if(n <= 2){
            return n;
        }
        
        if(dp[n] != -1) return dp[n];

        // Either take 1 step or 2 steps
        int take = rec(n-1, dp);
        int notTake = rec(n-2, dp);

        dp[n] = take + notTake;
        return dp[n];
    }
}

// TC O(n)
// SC O(n) dp[]
