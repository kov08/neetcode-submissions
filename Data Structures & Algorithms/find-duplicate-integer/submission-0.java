class Solution {
    public int findDuplicate(int[] nums) {
        int l = nums[0], r = nums[nums[0]];
        while(l != r){
            l = nums[l];
            r = nums[nums[r]];
        }
        int s2 = 0;
        while(s2 != l){
            s2 = nums[s2];
            l = nums[l];
        }
        return s2;
    }
}
