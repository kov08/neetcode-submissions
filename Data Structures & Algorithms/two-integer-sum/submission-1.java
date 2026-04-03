class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[] {map.get(target - nums[i]),i};
            }
            map.putIfAbsent(nums[i], i);
        }
        return new int[2];
    }
}

// TC: O(N) for loop
// SC: O(N) as hashMap can grow upto the size of the nums.length