class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        for(int i = 0; i < len; i++){
            if(i == 0){
                leftMax[i] = height[i];
            } else if(height[i] > leftMax[i-1]){
                leftMax[i] = height[i];
            } else{
                leftMax[i] = leftMax[i-1];
            }
        }

        for(int j = len - 1; j >= 0; j--){
            if(j == len - 1){
                rightMax[j] = height[j];
            } else if( height[j] > rightMax[j+1]){
                rightMax[j] = height[j];
            }else{
                rightMax[j] = rightMax[j+1];
            }
        }

        int waterAccum = 0;
        for(int k = 0; k < len; k++){
            if(height[k] < leftMax[k] && height[k] < rightMax[k]){
                waterAccum += Math.min(leftMax[k], rightMax[k]) - height[k];
            }
        }

        return waterAccum;
    }
}
