class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length -1;
        while(l <= r){
            int mid = ( l + r ) / 2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    // public int search(int[] nums, int target) {
    //     int res = bs(nums, 0, nums.length - 1, target);
    //     return res;
    // }

    // private int bs(int[] nums,int l, int r, int target){
    //     int mid = (l + r) / 2;
    //     if(l <= r){
    //         if(nums[mid] == target){
    //             return mid;
    //         } else if( nums[mid] < target){
    //             return bs(nums, mid + 1, r, target);
    //         } else {
    //             return bs(nums, l, mid - 1, target);
    //         }
    //     }
    //     return -1;
    // }
}

