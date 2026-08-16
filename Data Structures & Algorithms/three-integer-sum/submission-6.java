class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        int i = 0;
        while(i < nums.length - 2){
            if(nums[i] > 0) break;
            while(i > 0 && i < nums.length -2 && nums[i] == nums[i-1]) {i++;}
            
            int l = i+1, r = nums.length-1;
            while(l < r){
                while(l < r && l > i+1 && nums[l] == nums[l-1]) {l++;}
                while(l < r && r < nums.length-1 && nums[r] == nums[r+1]) {r--;}
                if(l == r) break;
                if(nums[l] + nums[r] == -nums[i]){
                    List<Integer> temp = List.of(nums[i], nums[l], nums[r]);
                    l++;
                    r--;
                    ans.add(temp);
                } else if( nums[l] + nums[r] + nums[i] < 0){
                    l++;
                } else {
                    r--;
                }
            }
            i++;
        }
        return ans;
    }
}
// TC: O(n^2)
// SC: O(1);