class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] lMax = new int[len];
        int[] rMax = new int[len];
        lMax[0] = height[0];
        rMax[len-1] = height[len-1];

        for(int i = 1; i < len; i++){
            lMax[i] = Math.max(lMax[i-1], height[i]);
        }

        for(int i = len - 2; i >= 0; i--){
            rMax[i] = Math.max(rMax[i+1], height[i]);
        }

        int waterAccumulation = 0;
        for(int i = 1; i  < height.length-1; i++){
            int temp = Math.min(lMax[i-1], rMax[i+1]) - height[i];
            if(temp > 0) waterAccumulation += temp;
        }

        return waterAccumulation;
    }
}

// TC O(n)
