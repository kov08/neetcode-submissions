class Solution {
    public int maxArea(int[] heights) {
        //  Not Sorted array
        // move which is smaller bar
        int l = 0;
        int r = heights.length - 1;
        
        // keep track of global Max and local
        int gMax = 0;

        while(l < r){
            int area = (r-l) * Math.min(heights[l], heights[r]);
            gMax = Math.max(area, gMax);

            if(heights[l] < heights[r]){
                l++;
            } else {
                r--;
            }
        }

        // return res
        return gMax;
    }
}

// TC O(N)
// SC O(1)
