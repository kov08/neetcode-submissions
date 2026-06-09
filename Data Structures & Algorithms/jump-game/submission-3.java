class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return rec(0, nums, dp);
    }

    private boolean rec(int ind, int[] nums, Boolean[] dp){
        // base case 
        if(ind >= nums.length-1) return true;

        if (dp[ind] != null) return dp[ind];

        int maxSteps = nums[ind];
        
        for(int step = 1; step <= maxSteps; step++){
            if(rec(ind + step, nums, dp)){
                dp[ind] = true;
                return dp[ind];
            }
        }

        dp[ind] = false;
        return dp[ind];
    }

}

// Without dp[] TC: O()
