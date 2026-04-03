class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length  < 2){
            return false;
        } 

        HashSet<Integer> set = new HashSet<>();

        for(int num: nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }

        return false;
    }
}

// TC: O(N)
// SC: O(N)