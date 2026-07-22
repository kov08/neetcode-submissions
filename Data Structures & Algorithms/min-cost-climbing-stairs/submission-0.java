class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return rec(cost.length, cost, dp);
    }

    private int rec(int ind, int[] cost, int[] dp){
        // explain everything in terms of index
        // Basecase
        if(ind == 0 || ind == 1) return cost[ind];
        if(ind < cost.length){
            if (dp[ind] != -1) return dp[ind];
        }
        // possible scenarios   
        // take and nontake
        int take = rec(ind - 1, cost, dp);
        int nonTake = rec(ind - 2, cost, dp);

        // return
        int min = Math.min(take, nonTake);
        if( ind < cost.length){
            dp[ind] = cost[ind] + min;
        } else{
            dp[ind] = min;
        }
        return dp[ind];
    }
}
