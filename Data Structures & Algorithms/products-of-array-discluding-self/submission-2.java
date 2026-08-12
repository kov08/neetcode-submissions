class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] l2r = new int[len];
        int[] r2l = new int[len];
        l2r[0] = 1; 
        r2l[len-1] = 1;
        
        for(int i = 1; i < len; i++){
            l2r[i] = l2r[i-1] * nums[i-1];
        }
        
        for(int i = len -2; i >= 0; i--){
            r2l[i] = r2l[i+1] * nums[i+1];
        }

        int[] ans = new int[len];
        for(int i = 0; i < len; i++){
            ans[i] = l2r[i] * r2l[i];
        }

        return ans;
    }
}  

// TC: O(n)
// SC: O(n)
