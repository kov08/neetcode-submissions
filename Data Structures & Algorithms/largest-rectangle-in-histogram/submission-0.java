class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] maxArea = new int[heights.length];
        for(int i = 0; i < heights.length; i++){
            int lDum = i-1;
            int lA = 0, rA = 0;
            while(lDum >= 0 && heights[lDum] >= heights[i]){
                lA++;
                lDum--;
            }
            int rDum = i+1;
            while(rDum < heights.length && heights[rDum] >= heights[i]){
                rA++;
                rDum++;
            }
            maxArea[i] = heights[i] * (lA+rA+1);
        }

        int max = Integer.MIN_VALUE;
        for(int a : maxArea){
            max =  Math.max(max, a);
        }
        return max;
    }
}
