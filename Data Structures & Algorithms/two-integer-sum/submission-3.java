class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int tmp = nums[i];
            if(hMap.containsKey(tmp)){
                return new int[]{hMap.get(tmp), i};
            } else{
                hMap.put(target - tmp, i);
            }
        }
        return new int[]{-1,-1};
    }
}

// TC: O(n)
// SC: O(n)