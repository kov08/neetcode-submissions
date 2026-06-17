class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // List<Integer> lst = new ArrayList<>();
        rec(0, nums, ans );
        return ans;
    }

    private void rec(int ind, int[] nums, List<List<Integer>> ans){
        
        if(ind  == nums.length){
            List<Integer> lst = new ArrayList<>();
            for(int i :nums){
                lst.add(i);
            }
            ans.add(lst);
            return;
        }

        for(int i = ind; i < nums.length; i++){
            swap(nums, ind, i);
            rec(ind + 1, nums, ans);
            swap(nums, ind, i);
        }
    }

    private void swap(int[] nums, int i, int ind){
        int temp = nums[i];
        nums[i] = nums[ind];
        nums[ind] = temp;
    }
}

// TC O(n * n!)
// SC O(n!) for ans + O(n) for auxilury stack space

