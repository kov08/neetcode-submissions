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

        // Bottom up approach where we start from  bottom 2 and reached till the given number
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

// TC O(n)
// SC O(n) dp[]
