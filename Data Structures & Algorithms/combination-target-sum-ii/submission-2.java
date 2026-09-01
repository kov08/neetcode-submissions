class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans =  new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        rec(0, target, candidates, lst, ans);
        return ans;
    }

    private void rec(int i, int t, int[] nums, List<Integer> lst, List<List<Integer>> ans){
        if(t == 0){
            ans.add(new ArrayList<>(lst));
            return;
        } else if(i == nums.length || t < 0 || t < nums[i]){
            return;
        } 

        // take
        lst.add(nums[i]);
        rec(i+1, t - nums[i], nums, lst, ans);
        lst.remove(lst.size() - 1);

        // Not take NO DUplicates
        while(i+1 < nums.length && nums[i+1] == nums[i]){
            i++;
        }
        rec(i+1, t, nums, lst, ans);
        
    }
}

// TC O(N*2^N)
// SC O(N)
