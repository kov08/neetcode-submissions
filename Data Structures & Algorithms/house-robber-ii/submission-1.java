class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        if(n > 2){
            int zero = rec(0, nums.length-2, nums, dp);
            Arrays.fill(dp, -1);
            int one = rec(1, nums.length-1, nums, dp);
            return Math.max(zero, one);
        } else if (n == 2){
            return Math.max(nums[0], nums[1]);
        } else if (n == 1){
            return nums[0];
        } else{
            return 0;
        }
    }

    private int rec(int f, int l, int[] nums, int[] dp){
        if(l < f) return 0;
        
        if(dp[l] != -1) return dp[l];

        // nt
        int nt = rec(f, l-1, nums, dp);
        // t
        int t = nums[l] + rec(f, l-2, nums, dp);

        dp[l] = Math.max(t, nt);
        return dp[l];
    }
}
