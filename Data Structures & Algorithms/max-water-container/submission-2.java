class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1, gMax = 0;
        while(l < r){
            int area = (r - l) * Math.min(heights[l], heights[r]);
            gMax = Math.max(gMax, area);

            if(heights[l] < heights[r]){
                l++;
            } else {
                r--;
            }
        }
        return gMax;
    }
}

// TC O(n)
// SC O(1)