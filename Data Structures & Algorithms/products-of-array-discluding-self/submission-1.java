class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length, j = len-1;
        int[] lProd = new int[len];
        int[] rProd = new int[len];

        for (int i = 0; i < len; i++){
            if(i == 0){
                lProd[i] = 1;
            } else{
                lProd[i] = lProd[i -1] * nums[i-1];
            }

            if(j == len-1){
                rProd[j] = 1;
            } else{
                rProd[j] = rProd[j +1] * nums[j+1];
            }
            j--;
        }

        int [] ans = new int[len];
        for(int i = 0; i < len; i++){
            ans[i] = lProd[i] * rProd[i];
        }

        return ans;
    }
}  
