class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp ,-1);
        return rec(nums.length-1, nums, dp);
    }

    private int rec(int ind, int[] nums, int[] dp){
        // Base conditions
        if(ind < 0) return 0;
        if(ind == 0 ) return nums[0];

        if(dp[ind] != -1) return dp[ind];
        // Explore everything in terms of index
        int nt = rec(ind - 1, nums, dp);
        int t = nums[ind] + rec(ind - 2, nums, dp);

        // return
        dp[ind] = Math.max(nt , t); 
        return dp[ind];
    }
}
