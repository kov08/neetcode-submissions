class Solution {
    public int maxProfit(int[] nums) {
        if(nums.length <= 1) return 0;

        int maxProf = 0;
        int l = 0, r = l +1;
        while(r < nums.length){
            if(nums[l] > nums[r]){
                l = r; 
                r++;
            } else {
                maxProf = Math.max(maxProf, nums[r] - nums[l]);
                r++;
            }
        }
        return maxProf;
    }
}

// TC: O(N)
// SC: O(1)
