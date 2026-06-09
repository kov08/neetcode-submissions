class Solution {
    public boolean canJump(int[] nums) {
        return rec(0, nums[0], nums);
    }
    private boolean rec(int ind, int maxInd, int[] nums){
        // base case 
        if(ind >= nums.length-1) return true;
        if(nums[ind] == 0) return false;

        maxInd = ind + nums[ind];
        boolean nonTake, take;

        for(int index = 1; index <= maxInd; index++){
            if(ind + index <= maxInd){
                if(rec(ind + index, maxInd, nums)){
                    return true;
                }
            }
        }

        return false;
    }

}
