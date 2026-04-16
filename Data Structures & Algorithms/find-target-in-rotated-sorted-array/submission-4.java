class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len -1;

        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[l] <= nums[mid]){
                if(target < nums[mid] && target >= nums[l]){
                    r = mid - 1;
                } else{
                    l = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[r]){
                    l = mid + 1;
                } else{
                    r = mid -1;
                }
            }
        }

        return -1;
    }
}
// TC: log(len)
// SC: O(1)