class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int  l = 0, r = len -1;

        while(l <= r){
            int mid  =(l + r) / 2;
            if(mid-1 >= 0 && nums[mid] < nums[mid-1] && mid+1 < len && nums[mid] < nums[mid+1]){
                return nums[mid];
            } else if( nums[mid] >= nums[l] && nums[l] > nums[r]){
                l = mid + 1;
            } else { 
                r = mid - 1;
            }
        }
        return nums[l];
    }
}
// TC: log(len)
// SC: O(1)
