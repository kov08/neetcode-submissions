class Solution {
    public int[] productExceptSelf(int[] nums) {
        int nLen = nums.length;
        int[] l2r = new int[nLen];
        int[] r2l = new int[nLen];
        
        l2r[0] = nums[0];
        r2l[nLen - 1] = nums[nLen - 1];

        // OUTPUT
        int[] output = new int[nLen];
        
        // Cal l2r and r2l array
        for(int i = 1; i < nLen; i++){
            l2r[i] = l2r[i-1] * nums[i];
            r2l[nLen - 1 - i] = r2l[nLen - i] * nums[nLen -1 - i];
        }

        // cal output array based on the l2r and r2l
        for(int i = 0; i < nLen; i++){
            output[i] = ((i-1)>= 0 ? l2r[i - 1] : 1) * ((i+1)<nLen ? r2l[i + 1]: 1);
        }

        // return
        return output;
    }
}  

// TC: O(N) 2 for loop runs n times;
// SC: O(N); r2l, r2l and output array
