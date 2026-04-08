class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // as two sume target would be the sum of two element
        int l = 0, r = nums.length -1, mid = 0;

        // Required sorted array to apply pointers
        Arrays.sort(nums);
        
        // Intorduce a return List
        List<List<Integer>> res = new ArrayList<>();
         
        while(l < r){
            if(nums[l] > 0) return res;
            twoSum(nums, l, res);
            
            l++;
            while(l < r && nums[l] == nums[l - 1]){
                l++;
            }
        }

        return res;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> res){
        int l = i + 1, r = nums.length-1;
        int target = -nums[i];
        while(l < r){
            int sum = nums[l] + nums[r];
            if( sum == target){
                res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                l++;
                r--;
                while(l < r && nums[l - 1] == nums[l]){
                    l++;
                }
                while(l < r && nums[r] == nums[r+1]){
                    r--;
                }
            } else if (sum < target){
                l++;
            } else{
                r--;
            }
        }
    }
}

// TC O(N^2)
// SC O(N)
